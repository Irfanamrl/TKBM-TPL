//
// Created by Irfan Amrullah on 12/7/20.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_helloworld_MainActivity_add( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x + y;
}