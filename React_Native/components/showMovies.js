import React, { useState, useEffect } from "react";
import {View, Text,FlatList,TouchableOpacity,Image,Dimensions,StyleSheet,ActivityIndicator,TextInput} from "react-native";
import axios from "axios";
const URL ="https://api.themoviedb.org/3/discover/movie?api_key=ec22bcac3d47ff20ef15f6bb599acfb7&page=";
const imgUrl = "https://image.tmdb.org/t/p/original";
const windowWidth = Dimensions.get('window').width;
const showMovies = (props) => {
 
  const [loader, setLoader] = useState(false);
  const [movieArray, setMovieArray] = useState([]);
  const [pageNo, setPageNo] = useState(1);
  const [searchText, setSearchText] = useState("");
  const [filterArray, setFilterArray] = useState([]);
  const [spliceCount, setSpliceCount] = useState(5);
  useEffect(() => {
    setLoader(true);
    axios.get(`${URL}${pageNo}`).then(res => {
      setMovieArray(res.data.results);
      setFilterArray(res.data.results);
      setPageNo(pageNo + 1);
      setLoader(false);
    })
    .catch(err => {
      console.error("Can't Load Movies", err)
    });

  }, [])

    const filterMovieList = text => {
      const newData = filterArray.filter(function (item) {
      const itemData = item.title.toLowerCase()
      const textData = text.toLowerCase();
      return itemData.includes(textData);

    });

    setMovieArray(newData);
    setSearchText(text)
  }


  const renderListItem = ({ item, index }) => {
    let movieItem = item;
    let lengthOfArray = movieArray.slice(0, spliceCount).length
    if (lengthOfArray - 1 == index) {
      return <View style={{ flexDirection: "row", margin: 20, justifyContent: "center" }}>
        <TouchableOpacity style={styles.buttonStyle} onPress={() => setSpliceCount(prev => prev + 7)} >
          <Text>LOAD</Text>
        </TouchableOpacity>
      </View>
    } else {
      return <View
        style={{justifyContent: "center",}}
      >
        <View style={{ paddingLeft: 10, marginTop: 10 }}>
          <Image
            style={styles.imageStyle}
            source={{ uri: `${imgUrl}${movieItem.poster_path}` }}
            style={{ height: 300, width: 500, resizeMode: "contain"}}
          />
        </View>
        <View style={{ paddingLeft: 10, marginTop: 10 }}>
          <Text>Title : {movieItem.title}</Text>
          <Text>Overview : {movieItem.overview}</Text>
          <Text>Number Of Votes : {movieItem.vote_count}</Text>
        </View>

        <View
          style={{
            flexDirection: "row",
            justifyContent: "flex-end",
            paddingRight: 10,
            marginTop: 20,
          }}
        >
          <TouchableOpacity
            onPress={() => props.navigation.navigate("showMoviesDetails", {
              title: movieItem.original_title,
              description: movieItem.overview,
              image: movieItem.poster_path
            })}
            style={{
              height: 40,
              width: 180,
              backgroundColor: "grey",
              borderRadius: 5,
              alignItems: "center",
              justifyContent: "center",
              alignSelf: "flex-end",
            }}
          >
            <Text
              style={{
                color: "black",
                fontSize: 20,
              }}
            >
              Show Details
            </Text>
          </TouchableOpacity>
        </View>

        <View
          style={{ height: 3, backgroundColor: "grey", marginTop: 10 }}
        ></View>
      </View>

    }

  }

  const sortListById = () => {
    setLoader(true);
    setTimeout(() => {
      let tempArray = movieArray
      tempArray.sort(function (obj1, obj2) {
        return obj1.id - obj2.id;
      });
      setMovieArray(tempArray);
      setLoader(false);}, 5000)

  }

  if (loader) {
    return (
      <View style={{ flex: 1, backgroundColor: "grey", justifyContent: "center" }}>
        <ActivityIndicator color={"grey"} />
      </View>
    )
  }

  return (
    <View style={styles.viewStyle}>
      <View style={{ flexDirection: "row" }}>
        <TextInput
          style={styles.textInputStyle}
          onChangeText={(text) => {

            filterMovieList(text)
          }}
          value={searchText}
          underlineColorAndroid="transparent"
          placeholder="Search Movie"
        />
        <View style={{ marginLeft: 20 }}>
          <TouchableOpacity
            onPress={() => {
              setSearchText("")
              filterMovieList("")
            }}
            style={{
              height: 40,
              width: 30,
              backgroundColor: "grey",
              borderRadius: 3,
              marginRight: 10,
              justifyContent: "center",
            }}
          >
            <Text
              style={{
                color: "black",
                fontSize: 20,
                alignSelf: "center",
              }}
            >
              X
          </Text>
          </TouchableOpacity>
        </View>

        <View>
          <TouchableOpacity
            onPress={() => sortListById()}
            style={{
              height: 40,
              width: 30,
              backgroundColor: "grey",
              borderRadius: 3,
              justifyContent: "center",
            }}
          >
            <Text
              style={{
                color: "black",
                fontSize: 20,
                alignSelf: "center",
              }}
            >
              S
          </Text>
          </TouchableOpacity>
        </View>
      </View>


      <FlatList
        data={movieArray.slice(0, spliceCount)}
        contentContainerStyle={{ flexGrow: 1 }}
        ListEmptyComponent={() => (<View><Text>empty</Text></View>)}
        renderItem={renderListItem}
        keyExtractor={(item, index) => index.toString()}
      />
    </View>

  );
}

export default showMovies;

const styles = StyleSheet.create({
  viewStyle: {
    justifyContent: "center",
    flex: 1,
    padding: 20,
  },
  textStyle: {
    padding: 10,
  },
  textInputStyle: {
    height: 50,
    color:"black",
    borderWidth: 4,
    borderRadius:5,
    textShadowColor:"black",
    marginLeft: 20,
    marginRight: 20,
    
    backgroundColor: "grey",
    flex: 1,
  },
  container: {
    flex: 1,
    margin: 10,
    backgroundColor: "black",
    borderRadius: 6,
  },
  imageStyle: {
    resizeMode: "center",
    width: "100%",
    height: "50%",
  },
  buttonStyle: {
    height: 40,
    width: windowWidth * 0.6,
    borderColor: "black",
    backgroundColor:"grey",
    borderWidth: 4,
    borderRadius: 5,
    marginRight: 10,
    alignItems: "center",
    justifyContent: "center",
  }
});