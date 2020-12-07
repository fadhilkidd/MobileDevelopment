#include <jni.h>
#include <cstring>
#include <iostream>

extern "C"
JNIEXPORT jstring JNICALL
Java_id_ac_ui_rahmatfadhilah_helloworld_MainActivity_echo(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}