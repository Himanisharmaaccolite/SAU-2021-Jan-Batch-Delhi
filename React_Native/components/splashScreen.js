import React, { useEffect } from 'react';
import { View, Text } from 'react-native';


const splashScreen = (props) => {
;
  useEffect(
    () => {
      let time = setTimeout(() => props.navigation.navigate("showMovies"), 5000)
      return () => {
        clearTimeout(time)
      }
    },
    [] )


  return (
    <View style={{ flex: 1,justifyContent:"center",alignItems:"center",backgroundColor:"grey" }}>
      <Text style={{height: 80}}>Your Movie App Loading..</Text>

    </View>

  );

}
export default splashScreen;
