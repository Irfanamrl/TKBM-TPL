//
// Created by Irfan Amrullah on 12/7/20.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_MuhammadIrfanAmrullah_helloworld_MainActivity_add( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x + y;
}