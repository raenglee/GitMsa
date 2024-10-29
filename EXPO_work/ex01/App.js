import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Pressable, TouchableOpacity, Alert } from 'react-native';

export default function App() {

  const doPress1 = () => {
  Alert.alert('doPress1');
  };
  const doPress2 = () => {
    Alert.alert('doPress2');
  };

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Open up App.js to start working on your app!</Text>
      <Text style={styles.text}>Open up App.js to start working on your app!</Text>
      <Text style={styles.text}>Open up App.js to start working on your app!</Text>
      <TouchableOpacity style={styles.button} onPress={doPress1}>
        <Text style={styles.text}>터치 버튼</Text>
      </TouchableOpacity>
      <Pressable style={styles.button} onPress={doPress2}>
        <Text style={styles.text}>프레스 버튼</Text>
      </Pressable>
  
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#d267e3',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text:{
    fontSize: 32,
    color: 'white'
  },
  button:{
    backgroundColor: 'skyblue',
    padding: 10,
    borderRadius: 5,
    marginBottom: 10
  }
});
