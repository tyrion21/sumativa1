//// app/src/test/java/com/example/sumativa1/FirebaseAuthTest.kt
//package com.example.sumativa1
//
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Test
////import org.mockito.Mockito.`when`
////import org.mockito.Mockito.mock
//
//class FirebaseAuthTest {
//
//    private lateinit var firebaseAuth: FirebaseAuth
//    private lateinit var firebaseUser: FirebaseUser
//
//    @Before
//    fun setUp() {
//        firebaseAuth = mock(FirebaseAuth::class.java)
//        firebaseUser = mock(FirebaseUser::class.java)
//    }
//
//    @Test
//    fun testSignInWithEmailAndPassword() {
//        `when`(firebaseAuth.currentUser).thenReturn(firebaseUser)
//        `when`(firebaseUser.email).thenReturn("test@example.com")
//
//        val user = firebaseAuth.currentUser
//        assertNotNull(user)
//        assertEquals("test@example.com", user?.email)
//    }
//}