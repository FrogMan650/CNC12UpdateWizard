#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#ifndef bool
#define bool char
#define false ((bool)0)
#define true  ((bool)1)
#endif

#include "C:\graalvm-svm-java17-windows-gluon-22.1.0.1-Final\graalvm-svm-java17-windows-gluon-22.1.0.1-Final\lib\svm\clibraries\windows-amd64\include\aarch64cpufeatures.h"

int AArch64LibCHelperDirectives() {
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CPUFeatures)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fA53MAC)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fA53MAC)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fA53MAC = all_bits_set;
        is_unsigned = fieldHolder.fA53MAC > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fAES)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fAES)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAES = all_bits_set;
        is_unsigned = fieldHolder.fAES > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fASIMD)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fASIMD)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fASIMD = all_bits_set;
        is_unsigned = fieldHolder.fASIMD > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fCRC32)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fCRC32)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCRC32 = all_bits_set;
        is_unsigned = fieldHolder.fCRC32 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fDCPOP)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fDCPOP)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fDCPOP = all_bits_set;
        is_unsigned = fieldHolder.fDCPOP > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMBATOMICS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fDMBATOMICS)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMBATOMICS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fDMBATOMICS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fDMBATOMICS = all_bits_set;
        is_unsigned = fieldHolder.fDMBATOMICS > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMBATOMICS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fEVTSTRM)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fEVTSTRM)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fEVTSTRM = all_bits_set;
        is_unsigned = fieldHolder.fEVTSTRM > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fFP)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fFP)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFP = all_bits_set;
        is_unsigned = fieldHolder.fFP > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fLSE)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fLSE)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fLSE = all_bits_set;
        is_unsigned = fieldHolder.fLSE > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fPMULL)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fPMULL)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fPMULL = all_bits_set;
        is_unsigned = fieldHolder.fPMULL > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSHA1)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSHA1)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA1 = all_bits_set;
        is_unsigned = fieldHolder.fSHA1 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSHA2)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSHA2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA2 = all_bits_set;
        is_unsigned = fieldHolder.fSHA2 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSHA3)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSHA3)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA3 = all_bits_set;
        is_unsigned = fieldHolder.fSHA3 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSHA512)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSHA512)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA512 = all_bits_set;
        is_unsigned = fieldHolder.fSHA512 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXRPREFETCH:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSTXRPREFETCH)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXRPREFETCH:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSTXRPREFETCH)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSTXRPREFETCH = all_bits_set;
        is_unsigned = fieldHolder.fSTXRPREFETCH > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXRPREFETCH:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSVE)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSVE)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSVE = all_bits_set;
        is_unsigned = fieldHolder.fSVE > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CPUFeatures *) 0)->fSVE2)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CPUFeatures, fSVE2)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSVE2 = all_bits_set;
        is_unsigned = fieldHolder.fSVE2 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    return 0;
}

int main(void) {
    return AArch64LibCHelperDirectives();
}
