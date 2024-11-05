import axios from "axios";
import { StatusBar } from "expo-status-bar";
import {
  Text,
  View,
  TouchableOpacity,
  TextInput,
  Pressable,
  Alert,
} from "react-native";

export default function App() {

  const doSignUp = async()=>{
    try{
      const res = await axios.post('http://m.hellomh.site/users/join',{
        "email": "ddd@naver.com",
        "name": "홍길동",
        "password": "abcd1234"
      });
      
      if(res.status==200){
        Alert.alert("Sign Up","회원가입이 완료되었습니다.");
        return;
      }
      // console.log(JSON.stringify(res));
    }catch(err){
      // console.error(JSON.stringify(err));
      Alert.alert("Sign Up","회원가입에 실패하였습니다."+err.response.data);
      return;
    }

  }

  return (
    <View className="flex-1 justify-center items-center bg-white">
      <StatusBar style="auto" />
      <Text className="text-center mt-3 text-2xl font-light text-orange-300">
        WelcomeToMyAPP
      </Text>
      {/* Additional components goes here */}
      <View className="mt-5 mx-5">
        <View>
          <Text className="text-gray-400">EMAIL:</Text>
          <TextInput
            placeholder="Enter Email..."
            className="border border-dotted p-2 text-gray-500 border-amber-400 mt-1"
          />
        </View>
        <View className="mt-3">
          <Text className="text-gray-400">PASSWORD:</Text>
          <TextInput
            secureTextEntry
            placeholder="Enter Password..."
            className="border text-gray-500 border-dotted p-2 border-amber-400 mt-1"
          />
        </View>

        <View className="bg-slate-500 p-3 my-5">
          <TouchableOpacity onPress={doSignUp}>
            <Text className="text-center font-normal text-white text-base">
              SingUp
            </Text>
          </TouchableOpacity>
        </View>

        <Text className="text-center font-normal text-gray-500 text-base mt-3">
          OR
        </Text>
        <View className="bg-slate-500 p-3 my-5">
          <TouchableOpacity>
            <Text className="text-center font-normal text-white text-base">
              Sign in with Google
            </Text>
          </TouchableOpacity>
        </View>
        <View className="mt-6 flex-row justify-center">
          <Text className="">New to FreeCodeCamp? </Text>
          <TouchableOpacity>
            <Text className="text-amber-500">Create an Account</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}