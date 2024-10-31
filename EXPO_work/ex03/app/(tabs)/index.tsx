import { Link, useRouter } from "expo-router";
import { Image, StyleSheet, Platform, View, Text } from "react-native";

/*
  replace push
*/

export default function HomeScreen() {
  // const router = useRouter();
  // router.push('/home');
  // router.replace('/home');
  return (
    <View style={{ marginTop: 30 }}>
      <Text style={{ fontSize: 30 }}> INDEX </Text>
      <Link href="/(tabs)/lotto" replace>
        <Text style={{ fontSize: 30 }}>Lotto</Text>
      </Link>
    </View>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: "row",
    alignItems: "center",
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: "absolute",
  },
});
