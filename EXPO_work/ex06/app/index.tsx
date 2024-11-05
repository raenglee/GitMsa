import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet, Image } from 'react-native';
import { FontAwesome } from '@expo/vector-icons';
import { useRouter } from 'expo-router';

export default function LoginScreen() {
    const router = useRouter();

  return (
    <View style={styles.container}>
      {/* Logo */}
      <Image
        source={{ uri: 'https://example.com/your-logo-url.png' }}
        style={styles.logo}
      />
      <Text style={styles.appName}>GREEN</Text>

      {/* Description */}
      <View style={styles.descriptionContainer}>
        <Text style={styles.descriptionText}>3초 가입하고,</Text>
        <Text style={styles.descriptionText}>최대 10% 할인쿠폰 6종을 받으세요!</Text>
      </View>

      {/* Kakao Button */}
      <TouchableOpacity style={styles.kakaoButton}>
        <FontAwesome name="comment" size={20} color="black" />
        <Text style={styles.kakaoButtonText}>카카오로 3초 만에 시작하기</Text>
      </TouchableOpacity>

      {/* Apple Button */}
      <TouchableOpacity style={styles.appleButton}>
        <FontAwesome name="apple" size={20} color="white" />
        <Text style={styles.appleButtonText}>Apple로 계속하기</Text>
      </TouchableOpacity>

      {/* Other Options */}
      <View style={styles.optionsContainer}>
        <TouchableOpacity style={styles.iconButton}>
          <FontAwesome name="facebook" size={30} color="#3b5998" />
        </TouchableOpacity>
        <TouchableOpacity style={styles.iconButton}>
          <FontAwesome name="google" size={30} color="#DB4437" />
        </TouchableOpacity>
      </View>

      {/* Footer Links */}
      <View style={styles.footerContainer}>
      <TouchableOpacity onPress={()=>{router.push("/join")}}>
        <Text style={styles.footerText}>회원가입</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={()=>{router.push("/login")}}>
        <Text style={styles.footerText}>이메일 로그인</Text>
        </TouchableOpacity>
        <Text style={styles.footerText}>문의하기</Text>
      </View>

      {/* Language Option */}
      <Text style={styles.languageOption}>한국인이 아니신가요? 일본 로 그인/가입</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#1c1d1e',
    alignItems: 'center',
    justifyContent: 'center',
  },
  logo: {
    width: 80,
    height: 80,
    marginBottom: 10,
  },
  appName: {
    fontSize: 28,
    color: 'pink',
    fontWeight: 'bold',
    marginBottom: 30,
  },
  descriptionContainer: {
    marginBottom: 20,
    alignItems: 'center',
  },
  descriptionText: {
    color: '#fff',
    fontSize: 16,
  },
  kakaoButton: {
    flexDirection: 'row',
    backgroundColor: '#FEE500',
    alignItems: 'center',
    justifyContent: 'center',
    width: '80%',
    padding: 15,
    borderRadius: 10,
    marginBottom: 10,
  },
  kakaoButtonText: {
    color: '#000',
    fontSize: 16,
    marginLeft: 10,
  },
  appleButton: {
    flexDirection: 'row',
    backgroundColor: '#000',
    alignItems: 'center',
    justifyContent: 'center',
    width: '80%',
    padding: 15,
    borderRadius: 10,
    marginBottom: 20,
  },
  appleButtonText: {
    color: '#fff',
    fontSize: 16,
    marginLeft: 10,
  },
  optionsContainer: {
    flexDirection: 'row',
    marginBottom: 20,
  },
  iconButton: {
    marginHorizontal: 10,
  },
  footerContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: '80%',
    marginBottom: 20,
  },
  footerText: {
    color: '#fff',
    fontSize: 14,
  },
  languageOption: {
    color: '#666',
    fontSize: 12,
  },
});
