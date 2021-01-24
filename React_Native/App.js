import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import showMovies from './components/showMovies';
import showMoviesDetails from './components/showMovieDetails';
import splashScreen from './components/splashScreen';

const App = () => {

  const Stack = createStackNavigator();
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="splashScreen">
        <Stack.Screen name="splashScreen" component={splashScreen} options={{ headerShown: false }} />
        <Stack.Screen name="showMovies" component={showMovies} options={{ headerShown: false }} />
        <Stack.Screen name="showMoviesDetails" component={showMoviesDetails} options={({ route }) => ({ title: route.params.title })} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};


export default App;
