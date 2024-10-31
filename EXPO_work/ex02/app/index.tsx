// export default function Home(){
// }

import AA from "@/mcomponents/aa";
import { useRouter } from "expo-router";
import { useEffect, useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

// useState useEffect redux -> component
// ref, reactive, watch, watchEffect, pinia -> component

const Index = () => {
  const router = useRouter();

  const onPress = () => {
    router.push("/(tabs)");
  };
  const onConsole = () => {
    console.log("This is console log.");
  };
  const onMyMain = () => {
    router.push("/mymain");
  };
//   watch([],()=>{});
// 최초에 한번만실행
  useEffect(()=>{
    console.log("Index component useEffect");
  },[]);

  return (
    // <View style={{ marginTop: 50 }}>
    <View style={styles.container}>
      <Text style={styles.text}>Index</Text>
      <Text style={styles.text}>
        RouterLink - router.push Link - router.push
      </Text>
      <TouchableOpacity onPress={onPress}>
        <Text>Click Me</Text>
        <Text style={styles.text}>이거 누르면 변경된다</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={onConsole}>
        <Text style={styles.text}>이거 누르면 출력된다.</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={onMyMain}>
        <Text style={styles.text}>이거 누르면 MyMain으로 간다</Text>
      </TouchableOpacity>
      <AA />
    </View>
  );
};
export default Index;

const styles = StyleSheet.create({
  container: {
    marginTop: 50,
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  text: {
    fontFamily: "JUA",
    fontSize: 20,
    // fontWeight: "bold",
  },
});
