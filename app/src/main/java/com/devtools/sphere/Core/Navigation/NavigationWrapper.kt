package com.devtools.sphere.Core.Navigation

import Forgot_Password_Screen
import LoginScreen
import Phone_NumberScreen
import SignUpScreen
import SplashScreen
import SplashView
import Verification__NumberScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devtools.sphere.View.LoginAndRegister.Congratulation_view
import com.devtools.sphere.View.LoginAndRegister.Login_View
import com.devtools.sphere.View.LoginAndRegister.Password.ForgotPasswordView
import com.devtools.sphere.View.LoginAndRegister.PhoneNumberView
import com.devtools.sphere.View.LoginAndRegister.SignUpView
import com.devtools.sphere.View.LoginAndRegister.verificationEmail_view
import com.devtools.sphere.View.LoginAndRegister.verificationPhoneNumber
import com.devtools.sphere.View.start_View
import congratulationScreen
import kotlinx.coroutines.delay
import startScreen
import verifiEmailScreen


class NavigationWrapper {

    @Composable
    fun Navigation() {
        val navHostController = rememberNavController()

        var hasNavigated by rememberSaveable { mutableStateOf(false) }


        LaunchedEffect(true) {
            if (!hasNavigated) {
                delay(3000L)
                navHostController.navigate(startScreen)
                hasNavigated = true
            }
        }

        NavHost(navController = navHostController, startDestination = SplashScreen) {

            composable<SplashScreen> {
                SplashView()
            }

            composable<startScreen> {
                start_View {
                    navHostController.navigate(LoginScreen)
                }
            }

            composable<SignUpScreen> {
                SignUpView {
                    navHostController.navigate(verifiEmailScreen)
                }
            }

            composable<LoginScreen> {
                Login_View(
                    NexView = {
                        navHostController.navigate(SignUpScreen)
                    },
                    reset_password = {
                        navHostController.navigate(Forgot_Password_Screen)
                    }
                )
            }

            composable<verifiEmailScreen> {
                verificationEmail_view {
                    navHostController.navigate(Phone_NumberScreen)
                }
            }

            composable<Phone_NumberScreen> {
                PhoneNumberView {
                    navHostController.navigate(Verification__NumberScreen)
                }
            }

            composable<Verification__NumberScreen> {
                verificationPhoneNumber {
                    navHostController.navigate(congratulationScreen)
                }
            }

            composable<congratulationScreen> {
                Congratulation_view()
            }

            composable<Forgot_Password_Screen> {
                ForgotPasswordView {}
            }
        }
    }

}



