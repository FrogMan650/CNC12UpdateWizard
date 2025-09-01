#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#ifndef bool
#define bool char
#define false ((bool)0)
#define true  ((bool)1)
#endif

#include "C:\graalvm-svm-java17-windows-gluon-22.1.0.1-Final\graalvm-svm-java17-windows-gluon-22.1.0.1-Final\lib\svm\clibraries\windows-amd64\include\amd64cpufeatures.h"

int AMD64LibCHelperDirectives() {
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CPUFeatures)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fADX:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fADX)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fADX:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fADX)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fADX = all_bits_set;
        is_unsigned = fieldHolder.fADX > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fADX:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAES)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAES)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAES = all_bits_set;
        is_unsigned = fieldHolder.fAES > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAMD3DNOWPREFETCH:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAMD3DNOWPREFETCH)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAMD3DNOWPREFETCH:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAMD3DNOWPREFETCH)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAMD3DNOWPREFETCH = all_bits_set;
        is_unsigned = fieldHolder.fAMD3DNOWPREFETCH > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAMD3DNOWPREFETCH:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX = all_bits_set;
        is_unsigned = fieldHolder.fAVX > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX2)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX2 = all_bits_set;
        is_unsigned = fieldHolder.fAVX2 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512BW:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512BW)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512BW:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512BW)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512BW = all_bits_set;
        is_unsigned = fieldHolder.fAVX512BW > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512BW:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512CD:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512CD)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512CD:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512CD)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512CD = all_bits_set;
        is_unsigned = fieldHolder.fAVX512CD > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512CD:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512DQ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512DQ)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512DQ:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512DQ)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512DQ = all_bits_set;
        is_unsigned = fieldHolder.fAVX512DQ > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512DQ:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512ER:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512ER)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512ER:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512ER)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512ER = all_bits_set;
        is_unsigned = fieldHolder.fAVX512ER > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512ER:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512F:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512F)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512F:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512F)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512F = all_bits_set;
        is_unsigned = fieldHolder.fAVX512F > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512F:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512PF:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512PF)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512PF:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512PF)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512PF = all_bits_set;
        is_unsigned = fieldHolder.fAVX512PF > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512PF:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VAES:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VAES)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VAES:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VAES)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VAES = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VAES > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VAES:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VBMI)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VBMI)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VBMI = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VBMI > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VBMI2)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VBMI2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VBMI2 = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VBMI2 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VBMI2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VL:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VL)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VL:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VL)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VL = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VL > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VL:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VNNI:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VNNI)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VNNI:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VNNI)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VNNI = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VNNI > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VNNI:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPCLMULQDQ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VPCLMULQDQ)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPCLMULQDQ:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VPCLMULQDQ)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VPCLMULQDQ = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VPCLMULQDQ > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPCLMULQDQ:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPOPCNTDQ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAVX512VPOPCNTDQ)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPOPCNTDQ:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAVX512VPOPCNTDQ)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAVX512VPOPCNTDQ = all_bits_set;
        is_unsigned = fieldHolder.fAVX512VPOPCNTDQ > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAVX512VPOPCNTDQ:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI1:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fBMI1)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI1:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fBMI1)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fBMI1 = all_bits_set;
        is_unsigned = fieldHolder.fBMI1 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI1:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fBMI2)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fBMI2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fBMI2 = all_bits_set;
        is_unsigned = fieldHolder.fBMI2 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fBMI2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLMUL:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fCLMUL)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLMUL:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fCLMUL)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCLMUL = all_bits_set;
        is_unsigned = fieldHolder.fCLMUL > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLMUL:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLWB:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fCLWB)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLWB:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fCLWB)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCLWB = all_bits_set;
        is_unsigned = fieldHolder.fCLWB > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCLWB:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCMOV:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fCMOV)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCMOV:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fCMOV)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCMOV = all_bits_set;
        is_unsigned = fieldHolder.fCMOV > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCMOV:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCX8:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fCX8)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCX8:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fCX8)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCX8 = all_bits_set;
        is_unsigned = fieldHolder.fCX8 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCX8:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fERMS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fERMS)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fERMS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fERMS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fERMS = all_bits_set;
        is_unsigned = fieldHolder.fERMS > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fERMS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSH:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fFLUSH)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSH:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fFLUSH)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFLUSH = all_bits_set;
        is_unsigned = fieldHolder.fFLUSH > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSH:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSHOPT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fFLUSHOPT)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSHOPT:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fFLUSHOPT)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFLUSHOPT = all_bits_set;
        is_unsigned = fieldHolder.fFLUSHOPT > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFLUSHOPT:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFMA:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fFMA)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFMA:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fFMA)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFMA = all_bits_set;
        is_unsigned = fieldHolder.fFMA > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFMA:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFXSR:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fFXSR)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFXSR:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fFXSR)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFXSR = all_bits_set;
        is_unsigned = fieldHolder.fFXSR > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFXSR:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fHT)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHT:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fHT)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fHT = all_bits_set;
        is_unsigned = fieldHolder.fHT > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHT:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHV:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fHV)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHV:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fHV)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fHV = all_bits_set;
        is_unsigned = fieldHolder.fHV > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fHV:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLZCNT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fLZCNT)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLZCNT:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fLZCNT)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fLZCNT = all_bits_set;
        is_unsigned = fieldHolder.fLZCNT > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLZCNT:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fMMX:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fMMX)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fMMX:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fMMX)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fMMX = all_bits_set;
        is_unsigned = fieldHolder.fMMX > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fMMX:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPOPCNT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fPOPCNT)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPOPCNT:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fPOPCNT)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fPOPCNT = all_bits_set;
        is_unsigned = fieldHolder.fPOPCNT > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPOPCNT:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fRTM:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fRTM)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fRTM:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fRTM)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fRTM = all_bits_set;
        is_unsigned = fieldHolder.fRTM > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fRTM:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSHA)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSHA)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA = all_bits_set;
        is_unsigned = fieldHolder.fSHA > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE = all_bits_set;
        is_unsigned = fieldHolder.fSSE > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE2)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE2 = all_bits_set;
        is_unsigned = fieldHolder.fSSE2 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE3:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE3)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE3:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE3)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE3 = all_bits_set;
        is_unsigned = fieldHolder.fSSE3 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE3:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE41:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE41)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE41:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE41)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE41 = all_bits_set;
        is_unsigned = fieldHolder.fSSE41 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE41:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE42:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE42)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE42:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE42)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE42 = all_bits_set;
        is_unsigned = fieldHolder.fSSE42 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE42:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE4A:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSE4A)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE4A:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSE4A)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSE4A = all_bits_set;
        is_unsigned = fieldHolder.fSSE4A > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSE4A:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSSE3:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSSSE3)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSSE3:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSSSE3)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSSSE3 = all_bits_set;
        is_unsigned = fieldHolder.fSSSE3 > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSSSE3:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSC:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fTSC)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSC:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fTSC)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fTSC = all_bits_set;
        is_unsigned = fieldHolder.fTSC > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSC:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINV:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fTSCINV)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINV:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fTSCINV)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fTSCINV = all_bits_set;
        is_unsigned = fieldHolder.fTSCINV > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINV:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINVBIT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fTSCINVBIT)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINVBIT:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fTSCINVBIT)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fTSCINVBIT = all_bits_set;
        is_unsigned = fieldHolder.fTSCINVBIT > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fTSCINVBIT:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fVZEROUPPER:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fVZEROUPPER)));
    printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fVZEROUPPER:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fVZEROUPPER)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fVZEROUPPER = all_bits_set;
        is_unsigned = fieldHolder.fVZEROUPPER > 0;
        printf("NativeCodeInfo:AMD64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fVZEROUPPER:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    return 0;
}

int main(void) {
    return AMD64LibCHelperDirectives();
}
