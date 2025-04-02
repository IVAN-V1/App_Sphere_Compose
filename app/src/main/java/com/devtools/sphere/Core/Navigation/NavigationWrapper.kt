package com.devtools.sphere.Core.Navigation

import Forgot_Password_Screen
import HomeScreen
import LoginScreen
import NewPasswordScreen
import Phone_NumberScreen
import ResetPasswordEmailScreen
import ResetPasswordNumberScreen
import SignUpScreen
import VerifiResetEmailScreen
import VerifiResetNumberScreen
import Verification__NumberScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devtools.sphere.View.Home.HomeView
import com.devtools.sphere.View.LoginAndRegister.Register.Congratulation_view
import com.devtools.sphere.View.LoginAndRegister.Login.Login_View
import com.devtools.sphere.View.LoginAndRegister.Register.PhoneNumberView
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.Congratulation_view_newpassword
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.Reset_password_email
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.Reset_password_phone
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.Reset_verificationEmail_view
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.Reset_verificationPhoneNumber
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.fotgotPasswordView
import com.devtools.sphere.View.LoginAndRegister.ResetPassword_.newPasswordView
import com.devtools.sphere.View.LoginAndRegister.Register.SignUpView
import com.devtools.sphere.View.LoginAndRegister.Register.verificationEmail_view
import com.devtools.sphere.View.LoginAndRegister.Register.verificationPhoneNumber
import com.devtools.sphere.View.start_View
import congratulationScreen
import startScreen
import succesNewPasswordScreen
import verifiEmailScreen


class NavigationWrapper {

    @Composable
    fun Navigation() {
        val navHostController = rememberNavController()

        var hasNavigated by rememberSaveable { mutableStateOf(false) }


        NavHost(navController = navHostController, startDestination = startScreen) {


            composable<startScreen> {
                start_View (

                    ViewSignIn ={

                        navHostController.navigate(SignUpScreen)

                    },

                    skip = {


                        navHostController.navigate(LoginScreen)
                    }


                )

            }

            composable<SignUpScreen> {
                SignUpView (

                    ViewVerification = {
                        navHostController.navigate(verifiEmailScreen)
                    },
                    ViewLogin = {
                        navHostController.navigate(LoginScreen)
                    },


                )

            }

            composable<LoginScreen> {
                Login_View(
                    NexView = {
                        navHostController.navigate(SignUpScreen)
                    },
                    reset_password = {
                        navHostController.navigate(Forgot_Password_Screen)
                    },

                    NexView_Home={
                        navHostController.navigate(HomeScreen)
                    }


                )
            }


            composable <HomeScreen>{

                HomeView()

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
                Congratulation_view{

                    navHostController.popBackStack(
                        navHostController.graph.startDestinationId,
                        false
                    )

                    navHostController.navigate(LoginScreen)


                }



            }


            composable<Forgot_Password_Screen> {
                fotgotPasswordView(


                    nextView_email = {
                        navHostController.navigate(ResetPasswordEmailScreen)
                    },

                    nextView_phone = {
                        navHostController.navigate(ResetPasswordNumberScreen)
                    },


                    )


            }




            composable<ResetPasswordEmailScreen> {

                Reset_password_email {

                    navHostController.navigate(VerifiResetEmailScreen)

                }

            }






            composable<ResetPasswordNumberScreen> {

                Reset_password_phone {

                    navHostController.navigate(VerifiResetNumberScreen)

                }

            }

            composable<VerifiResetEmailScreen> {


                Reset_verificationEmail_view {

                    navHostController.navigate(NewPasswordScreen)

                }

            }

            composable<VerifiResetNumberScreen> {


                Reset_verificationPhoneNumber {

                    navHostController.navigate(NewPasswordScreen)
                }

            }



            composable<NewPasswordScreen> {

                newPasswordView {

                    navHostController.navigate(succesNewPasswordScreen)

                }

            }


            composable<succesNewPasswordScreen> {


                Congratulation_view_newpassword {
                    navHostController.popBackStack(
                        navHostController.graph.startDestinationId,
                        false
                    )
                    navHostController.navigate(LoginScreen)
                }

            }

        }
    }

}



