#include <jni.h>
#include <string>

extern "C" JNIEXPORT jobject JNICALL
Java_com_example_nativedemo_MainActivity_createUserFromJNI(
        JNIEnv *env,
        jobject,
        jstring name,
        jint old) {
    jclass userClass = env->FindClass("com/example/nativedemo/User");
    jobject user = env->AllocObject(userClass);
    jfieldID nameId = env->GetFieldID(userClass, "name", "Ljava/lang/String;");
    jfieldID oldId = env->GetFieldID(userClass, "old", "I");
    env->SetObjectField(user, nameId, name);
    env->SetIntField(user, oldId, old);
    return user;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativedemo_MainActivity_createUserInfoFromJNI(
        JNIEnv *env,
        jobject,
        jobject user) {
    jclass userDataClass = env->GetObjectClass(user);
    jmethodID methodId = env->GetMethodID(userDataClass, "getInfo", "()Ljava/lang/String;");
    auto result = (jstring) env->CallObjectMethod(user, methodId);
    return result;
}