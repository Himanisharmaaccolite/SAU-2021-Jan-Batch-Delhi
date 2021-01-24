import React from 'react'
import { View, Text, Dimensions, Image, StyleSheet, Linking, ScrollView, TouchableOpacity } from 'react-native'
const windowHeight = Dimensions.get('window').height;
const windowWidth = Dimensions.get('window').width;

export default function showMoviesDetails({ route }) {
    const imgUrl = "https://image.tmdb.org/t/p/original";
    const image = route.params.image;
    const movieName = route.params.title;

    return (
        <ScrollView>
            <View style={{ padding: 16 }}>
                <Image
                    style={styles.imageStyle}
                    source={{ uri: `${imgUrl}${image}` }}
                    style={{ height: windowHeight * 0.6, width: windowWidth * 0.9, resizeMode: "cover" }}/>

                <View style={{ flexDirection: "row", justifyContent: "space-between", marginVertical: 20 }}>
                    <TouchableOpacity onPress={() => alert(`${movieName}`)}>
                        <View style={styles.buttonStyle}>
                            <Text>Click</Text>
                        </View>
                    </TouchableOpacity>

                    <TouchableOpacity onPress={() => { Linking.openURL("https://www.accolite.com/") }} >
                            <View style={styles.buttonStyle}>
                            <Text>Show Details </Text>
                        </View>
                    </TouchableOpacity>
                </View>
                <Text>
                    This was, in many respects, a year to forget—but not so when it came to film. Although most were viewed on 
                    inadequately small screens, the legion of fiction and non-fiction releases that helped us cope with our 
                    pandemic-wracked reality delivered welcome doses of excitement, drama, terror, and humor. Whether tapping into 
                    universal hopes and fears, or incisively reflecting our current insane circumstances, they offered insight and 
                    escape, as well as thrills of a breathtakingly varied sort. No one knows if 2021 will bring us back to theaters 
                    or have us continuing to experience new works on our TVs, tablets and phones. Yet as evidenced by the numerous
                    gems that arrived over the course of the past twelve months, cinema remains as vital as ever. While we can’t 
                    celebrate them all, this year-long rundown has certainly tried to do justice to the finest that filmmakers had 
                    to offer. Dynamic, unique and altogether triumphant, these are our selections for the best movies of 2020.
                </Text>

            </View>
        </ScrollView>
    )
}
const styles = StyleSheet.create({

    imageStyle: {
        resizeMode: "center",
        width: "100%",
        height: "30%",
    },
    buttonStyle: {
        height: 40,
        width: windowWidth * 0.4,
        borderColor: "DarkKhaki",
        borderWidth: 3,
        borderRadius: 7,
        marginRight: 20,
        alignItems: "center",
        justifyContent: "center",
    }
});
