import { DarkTheme, DefaultTheme, ThemeProvider } from '@react-navigation/native';
import { useFonts } from 'expo-font';
import { Stack } from 'expo-router';
import * as SplashScreen from 'expo-splash-screen';
import { useEffect } from 'react';
import 'react-native-reanimated';

import { useColorScheme } from '@/hooks/useColorScheme';

// Prevent the splash screen from auto-hiding before asset loading is complete.
SplashScreen.preventAutoHideAsync();

export default function RootLayout() {
  const colorScheme = useColorScheme();
  const [loaded] = useFonts({
    SpaceMono: require('../assets/fonts/SpaceMono-Regular.ttf'),
    NotoSansBlack: require("../assets/fonts/NotoSansKR-Black.ttf"),
    NotoSansBold: require("../assets/fonts/NotoSansKR-Bold.ttf"),
    NotoSansLight: require("../assets/fonts/NotoSansKR-Light.ttf"),
    NotoSansMedium: require("../assets/fonts/NotoSansKR-Medium.ttf"),
    NotoSansRegular: require("../assets/fonts/NotoSansKR-Regular.ttf"),
    NotoSansThin: require("../assets/fonts/NotoSansKR-Thin.ttf"),
  });

  useEffect(() => {
    if (loaded) {
      SplashScreen.hideAsync();
    }
  }, [loaded]);

  if (!loaded) {
    return null;
  }

  return (
    <ThemeProvider value={colorScheme === 'dark' ? DarkTheme : DefaultTheme}>
      <Stack screenOptions={
        { headerShown: false }
      }>
      <Stack.Screen name="index" options={{ headerShown: false }} />
        <Stack.Screen name="(tabs)" options={{ headerShown: false }} />
        <Stack.Screen name="+not-found" />
      </Stack>
    </ThemeProvider>
  );
}
