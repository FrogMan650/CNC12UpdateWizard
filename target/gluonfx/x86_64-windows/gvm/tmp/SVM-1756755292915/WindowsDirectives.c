#ifndef _WIN64
#define _WIN64
#endif

#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#ifndef bool
#define bool char
#define false ((bool)0)
#define true  ((bool)1)
#endif

#include <windows.h>
#include <winsock.h>
#include <process.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <io.h>

int WindowsDirectives() {
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:CREATE_SUSPENDED:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CREATE_SUSPENDED)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:CREATE_SUSPENDED:PropertyInfo:signedness=$%s$\n", ((CREATE_SUSPENDED>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:CREATE_SUSPENDED:PropertyInfo:value=%llX\n", ((unsigned long long)CREATE_SUSPENDED));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:ERROR_TIMEOUT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(ERROR_TIMEOUT)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:ERROR_TIMEOUT:PropertyInfo:signedness=$%s$\n", ((ERROR_TIMEOUT>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:ERROR_TIMEOUT:PropertyInfo:value=%llX\n", ((unsigned long long)ERROR_TIMEOUT));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_ACCESS_VIOLATION:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(EXCEPTION_ACCESS_VIOLATION)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_ACCESS_VIOLATION:PropertyInfo:signedness=$%s$\n", ((EXCEPTION_ACCESS_VIOLATION>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_ACCESS_VIOLATION:PropertyInfo:value=%llX\n", ((unsigned long long)EXCEPTION_ACCESS_VIOLATION));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_CONTINUE_SEARCH:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(EXCEPTION_CONTINUE_SEARCH)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_CONTINUE_SEARCH:PropertyInfo:signedness=$%s$\n", ((EXCEPTION_CONTINUE_SEARCH>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_CONTINUE_SEARCH:PropertyInfo:value=%llX\n", ((unsigned long long)EXCEPTION_CONTINUE_SEARCH));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_IN_PAGE_ERROR:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(EXCEPTION_IN_PAGE_ERROR)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_IN_PAGE_ERROR:PropertyInfo:signedness=$%s$\n", ((EXCEPTION_IN_PAGE_ERROR>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:EXCEPTION_IN_PAGE_ERROR:PropertyInfo:value=%llX\n", ((unsigned long long)EXCEPTION_IN_PAGE_ERROR));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_DELETE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(FILE_SHARE_DELETE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_DELETE:PropertyInfo:signedness=$%s$\n", ((FILE_SHARE_DELETE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_DELETE:PropertyInfo:value=%llX\n", ((unsigned long long)FILE_SHARE_DELETE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_READ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(FILE_SHARE_READ)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_READ:PropertyInfo:signedness=$%s$\n", ((FILE_SHARE_READ>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:FILE_SHARE_READ:PropertyInfo:value=%llX\n", ((unsigned long long)FILE_SHARE_READ));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GENERIC_READ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(GENERIC_READ)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GENERIC_READ:PropertyInfo:signedness=$%s$\n", ((GENERIC_READ>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GENERIC_READ:PropertyInfo:value=%llX\n", ((unsigned long long)GENERIC_READ));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS:PropertyInfo:signedness=$%s$\n", ((GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS:PropertyInfo:value=%llX\n", ((unsigned long long)GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT:PropertyInfo:signedness=$%s$\n", ((GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT:PropertyInfo:value=%llX\n", ((unsigned long long)GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:INFINITE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(INFINITE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:INFINITE:PropertyInfo:signedness=$%s$\n", ((INFINITE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:INFINITE:PropertyInfo:value=%llX\n", ((unsigned long long)INFINITE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:INVALID_HANDLE_VALUE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(INVALID_HANDLE_VALUE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:INVALID_HANDLE_VALUE:PropertyInfo:value=%llX\n", ((unsigned long long)INVALID_HANDLE_VALUE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_COMMIT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEM_COMMIT)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_COMMIT:PropertyInfo:signedness=$%s$\n", ((MEM_COMMIT>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_COMMIT:PropertyInfo:value=%llX\n", ((unsigned long long)MEM_COMMIT));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_DECOMMIT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEM_DECOMMIT)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_DECOMMIT:PropertyInfo:signedness=$%s$\n", ((MEM_DECOMMIT>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_DECOMMIT:PropertyInfo:value=%llX\n", ((unsigned long long)MEM_DECOMMIT));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_MAPPED:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEM_MAPPED)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_MAPPED:PropertyInfo:signedness=$%s$\n", ((MEM_MAPPED>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_MAPPED:PropertyInfo:value=%llX\n", ((unsigned long long)MEM_MAPPED));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RELEASE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEM_RELEASE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RELEASE:PropertyInfo:signedness=$%s$\n", ((MEM_RELEASE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RELEASE:PropertyInfo:value=%llX\n", ((unsigned long long)MEM_RELEASE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RESERVE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEM_RESERVE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RESERVE:PropertyInfo:signedness=$%s$\n", ((MEM_RESERVE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:MEM_RESERVE:PropertyInfo:value=%llX\n", ((unsigned long long)MEM_RESERVE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:OPEN_EXISTING:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(OPEN_EXISTING)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:OPEN_EXISTING:PropertyInfo:signedness=$%s$\n", ((OPEN_EXISTING>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:OPEN_EXISTING:PropertyInfo:value=%llX\n", ((unsigned long long)OPEN_EXISTING));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_EXECUTE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE:PropertyInfo:signedness=$%s$\n", ((PAGE_EXECUTE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_EXECUTE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READ:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_EXECUTE_READ)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READ:PropertyInfo:signedness=$%s$\n", ((PAGE_EXECUTE_READ>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READ:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_EXECUTE_READ));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READWRITE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_EXECUTE_READWRITE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READWRITE:PropertyInfo:signedness=$%s$\n", ((PAGE_EXECUTE_READWRITE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_EXECUTE_READWRITE:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_EXECUTE_READWRITE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_NOACCESS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_NOACCESS)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_NOACCESS:PropertyInfo:signedness=$%s$\n", ((PAGE_NOACCESS>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_NOACCESS:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_NOACCESS));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READONLY:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_READONLY)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READONLY:PropertyInfo:signedness=$%s$\n", ((PAGE_READONLY>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READONLY:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_READONLY));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READWRITE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_READWRITE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READWRITE:PropertyInfo:signedness=$%s$\n", ((PAGE_READWRITE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_READWRITE:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_READWRITE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_WRITECOPY:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PAGE_WRITECOPY)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_WRITECOPY:PropertyInfo:signedness=$%s$\n", ((PAGE_WRITECOPY>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PAGE_WRITECOPY:PropertyInfo:value=%llX\n", ((unsigned long long)PAGE_WRITECOPY));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PROCESS_TERMINATE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PROCESS_TERMINATE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PROCESS_TERMINATE:PropertyInfo:signedness=$%s$\n", ((PROCESS_TERMINATE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:PROCESS_TERMINATE:PropertyInfo:value=%llX\n", ((unsigned long long)PROCESS_TERMINATE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STACK_SIZE_PARAM_IS_A_RESERVATION:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(STACK_SIZE_PARAM_IS_A_RESERVATION)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STACK_SIZE_PARAM_IS_A_RESERVATION:PropertyInfo:signedness=$%s$\n", ((STACK_SIZE_PARAM_IS_A_RESERVATION>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STACK_SIZE_PARAM_IS_A_RESERVATION:PropertyInfo:value=%llX\n", ((unsigned long long)STACK_SIZE_PARAM_IS_A_RESERVATION));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_ERROR_HANDLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(STD_ERROR_HANDLE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_ERROR_HANDLE:PropertyInfo:signedness=$%s$\n", ((STD_ERROR_HANDLE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_ERROR_HANDLE:PropertyInfo:value=%llX\n", ((unsigned long long)STD_ERROR_HANDLE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_INPUT_HANDLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(STD_INPUT_HANDLE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_INPUT_HANDLE:PropertyInfo:signedness=$%s$\n", ((STD_INPUT_HANDLE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_INPUT_HANDLE:PropertyInfo:value=%llX\n", ((unsigned long long)STD_INPUT_HANDLE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_OUTPUT_HANDLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(STD_OUTPUT_HANDLE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_OUTPUT_HANDLE:PropertyInfo:signedness=$%s$\n", ((STD_OUTPUT_HANDLE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:STD_OUTPUT_HANDLE:PropertyInfo:value=%llX\n", ((unsigned long long)STD_OUTPUT_HANDLE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:SYNCHRONIZE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(SYNCHRONIZE)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:SYNCHRONIZE:PropertyInfo:signedness=$%s$\n", ((SYNCHRONIZE>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:SYNCHRONIZE:PropertyInfo:value=%llX\n", ((unsigned long long)SYNCHRONIZE));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:TOKEN_QUERY:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(TOKEN_QUERY)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:TOKEN_QUERY:PropertyInfo:signedness=$%s$\n", ((TOKEN_QUERY>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:TOKEN_QUERY:PropertyInfo:value=%llX\n", ((unsigned long long)TOKEN_QUERY));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_ABANDONED:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(WAIT_ABANDONED)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_ABANDONED:PropertyInfo:signedness=$%s$\n", ((WAIT_ABANDONED>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_ABANDONED:PropertyInfo:value=%llX\n", ((unsigned long long)WAIT_ABANDONED));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_FAILED:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(WAIT_FAILED)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_FAILED:PropertyInfo:signedness=$%s$\n", ((WAIT_FAILED>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_FAILED:PropertyInfo:value=%llX\n", ((unsigned long long)WAIT_FAILED));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_OBJECT_0:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(WAIT_OBJECT_0)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_OBJECT_0:PropertyInfo:signedness=$%s$\n", ((WAIT_OBJECT_0>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_OBJECT_0:PropertyInfo:value=%llX\n", ((unsigned long long)WAIT_OBJECT_0));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_TIMEOUT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(WAIT_TIMEOUT)));
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_TIMEOUT:PropertyInfo:signedness=$%s$\n", ((WAIT_TIMEOUT>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:WindowsDirectives:ConstantInfo:WAIT_TIMEOUT:PropertyInfo:value=%llX\n", ((unsigned long long)WAIT_TIMEOUT));
    printf("NativeCodeInfo:WindowsDirectives:PointerToInfo:HANDLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(HANDLE)));
    printf("NativeCodeInfo:WindowsDirectives:PointerToInfo:HMODULE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(HMODULE)));
    printf("NativeCodeInfo:WindowsDirectives:PointerToInfo:wchar_t:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(wchar_t)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONDITION_VARIABLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CONDITION_VARIABLE)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CONTEXT)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:EFlags:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->EFlags)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:EFlags:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, EFlags)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.EFlags = all_bits_set;
        is_unsigned = fieldHolder.EFlags > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:EFlags:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R10:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R10)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R10:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R10)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R10 = all_bits_set;
        is_unsigned = fieldHolder.R10 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R10:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R11:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R11)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R11:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R11)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R11 = all_bits_set;
        is_unsigned = fieldHolder.R11 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R11:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R12:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R12)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R12:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R12)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R12 = all_bits_set;
        is_unsigned = fieldHolder.R12 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R12:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R13:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R13)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R13:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R13)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R13 = all_bits_set;
        is_unsigned = fieldHolder.R13 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R13:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R14:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R14)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R14:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R14)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R14 = all_bits_set;
        is_unsigned = fieldHolder.R14 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R14:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R15:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R15)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R15:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R15)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R15 = all_bits_set;
        is_unsigned = fieldHolder.R15 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R15:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R8:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R8)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R8:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R8)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R8 = all_bits_set;
        is_unsigned = fieldHolder.R8 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R8:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R9:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->R9)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R9:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, R9)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.R9 = all_bits_set;
        is_unsigned = fieldHolder.R9 > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:R9:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rax:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rax)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rax:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rax)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rax = all_bits_set;
        is_unsigned = fieldHolder.Rax > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rax:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbp:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rbp)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbp:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rbp)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rbp = all_bits_set;
        is_unsigned = fieldHolder.Rbp > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbp:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbx:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rbx)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbx:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rbx)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rbx = all_bits_set;
        is_unsigned = fieldHolder.Rbx > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rbx:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rcx:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rcx)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rcx:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rcx)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rcx = all_bits_set;
        is_unsigned = fieldHolder.Rcx > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rcx:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdi:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rdi)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdi:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rdi)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rdi = all_bits_set;
        is_unsigned = fieldHolder.Rdi > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdi:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdx:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rdx)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdx:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rdx)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rdx = all_bits_set;
        is_unsigned = fieldHolder.Rdx > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rdx:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rip:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rip)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rip:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rip)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rip = all_bits_set;
        is_unsigned = fieldHolder.Rip > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rip:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsi:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rsi)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsi:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rsi)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rsi = all_bits_set;
        is_unsigned = fieldHolder.Rsi > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsi:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsp:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((CONTEXT *) 0)->Rsp)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsp:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(CONTEXT, Rsp)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        CONTEXT fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Rsp = all_bits_set;
        is_unsigned = fieldHolder.Rsp > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:CONTEXT:StructFieldInfo:Rsp:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:CRITICAL_SECTION:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(CRITICAL_SECTION)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_POINTERS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(EXCEPTION_POINTERS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_POINTERS:StructFieldInfo:ContextRecord:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_POINTERS *) 0)->ContextRecord)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_POINTERS:StructFieldInfo:ContextRecord:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_POINTERS, ContextRecord)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_POINTERS:StructFieldInfo:ExceptionRecord:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_POINTERS *) 0)->ExceptionRecord)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_POINTERS:StructFieldInfo:ExceptionRecord:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_POINTERS, ExceptionRecord)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionAddress:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_RECORD *) 0)->ExceptionAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionAddress:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_RECORD, ExceptionAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionCode:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_RECORD *) 0)->ExceptionCode)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionCode:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_RECORD, ExceptionCode)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        EXCEPTION_RECORD fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ExceptionCode = all_bits_set;
        is_unsigned = fieldHolder.ExceptionCode > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionCode:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionInformation:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_RECORD *) 0)->ExceptionInformation)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:ExceptionInformation:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_RECORD, ExceptionInformation)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:NumberParameters:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((EXCEPTION_RECORD *) 0)->NumberParameters)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:NumberParameters:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(EXCEPTION_RECORD, NumberParameters)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        EXCEPTION_RECORD fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.NumberParameters = all_bits_set;
        is_unsigned = fieldHolder.NumberParameters > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:EXCEPTION_RECORD:StructFieldInfo:NumberParameters:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEMORYSTATUSEX)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwLength:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->dwLength)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwLength:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, dwLength)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwLength = all_bits_set;
        is_unsigned = fieldHolder.dwLength > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwLength:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwMemoryLoad:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->dwMemoryLoad)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwMemoryLoad:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, dwMemoryLoad)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwMemoryLoad = all_bits_set;
        is_unsigned = fieldHolder.dwMemoryLoad > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:dwMemoryLoad:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailExtendedVirtual:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullAvailExtendedVirtual)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailExtendedVirtual:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullAvailExtendedVirtual)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullAvailExtendedVirtual = all_bits_set;
        is_unsigned = fieldHolder.ullAvailExtendedVirtual > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailExtendedVirtual:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPageFile:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullAvailPageFile)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPageFile:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullAvailPageFile)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullAvailPageFile = all_bits_set;
        is_unsigned = fieldHolder.ullAvailPageFile > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPageFile:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPhys:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullAvailPhys)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPhys:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullAvailPhys)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullAvailPhys = all_bits_set;
        is_unsigned = fieldHolder.ullAvailPhys > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailPhys:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailVirtual:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullAvailVirtual)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailVirtual:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullAvailVirtual)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullAvailVirtual = all_bits_set;
        is_unsigned = fieldHolder.ullAvailVirtual > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullAvailVirtual:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPageFile:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullTotalPageFile)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPageFile:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullTotalPageFile)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullTotalPageFile = all_bits_set;
        is_unsigned = fieldHolder.ullTotalPageFile > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPageFile:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPhys:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullTotalPhys)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPhys:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullTotalPhys)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullTotalPhys = all_bits_set;
        is_unsigned = fieldHolder.ullTotalPhys > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalPhys:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalVirtual:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORYSTATUSEX *) 0)->ullTotalVirtual)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalVirtual:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORYSTATUSEX, ullTotalVirtual)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORYSTATUSEX fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.ullTotalVirtual = all_bits_set;
        is_unsigned = fieldHolder.ullTotalVirtual > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORYSTATUSEX:StructFieldInfo:ullTotalVirtual:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(MEMORY_BASIC_INFORMATION)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:AllocationBase:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->AllocationBase)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:AllocationBase:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, AllocationBase)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:AllocationProtect:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->AllocationProtect)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:AllocationProtect:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, AllocationProtect)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORY_BASIC_INFORMATION fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.AllocationProtect = all_bits_set;
        is_unsigned = fieldHolder.AllocationProtect > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:AllocationProtect:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:BaseAddress:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->BaseAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:BaseAddress:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, BaseAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Protect:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->Protect)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Protect:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, Protect)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORY_BASIC_INFORMATION fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Protect = all_bits_set;
        is_unsigned = fieldHolder.Protect > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Protect:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:RegionSize:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->RegionSize)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:RegionSize:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, RegionSize)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORY_BASIC_INFORMATION fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.RegionSize = all_bits_set;
        is_unsigned = fieldHolder.RegionSize > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:RegionSize:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:State:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->State)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:State:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, State)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORY_BASIC_INFORMATION fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.State = all_bits_set;
        is_unsigned = fieldHolder.State > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:State:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Type:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((MEMORY_BASIC_INFORMATION *) 0)->Type)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Type:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(MEMORY_BASIC_INFORMATION, Type)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        MEMORY_BASIC_INFORMATION fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.Type = all_bits_set;
        is_unsigned = fieldHolder.Type > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:MEMORY_BASIC_INFORMATION:StructFieldInfo:Type:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(OSVERSIONINFOEXA)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwBuildNumber:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->dwBuildNumber)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwBuildNumber:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, dwBuildNumber)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwBuildNumber = all_bits_set;
        is_unsigned = fieldHolder.dwBuildNumber > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwBuildNumber:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMajorVersion:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->dwMajorVersion)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMajorVersion:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, dwMajorVersion)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwMajorVersion = all_bits_set;
        is_unsigned = fieldHolder.dwMajorVersion > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMajorVersion:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMinorVersion:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->dwMinorVersion)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMinorVersion:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, dwMinorVersion)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwMinorVersion = all_bits_set;
        is_unsigned = fieldHolder.dwMinorVersion > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwMinorVersion:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwOSVersionInfoSize:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->dwOSVersionInfoSize)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwOSVersionInfoSize:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, dwOSVersionInfoSize)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwOSVersionInfoSize = all_bits_set;
        is_unsigned = fieldHolder.dwOSVersionInfoSize > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwOSVersionInfoSize:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwPlatformId:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->dwPlatformId)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwPlatformId:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, dwPlatformId)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwPlatformId = all_bits_set;
        is_unsigned = fieldHolder.dwPlatformId > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:dwPlatformId:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:szCSDVersion:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->szCSDVersion)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:szCSDVersion:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, szCSDVersion)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wProductType:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->wProductType)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wProductType:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, wProductType)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wProductType = all_bits_set;
        is_unsigned = fieldHolder.wProductType > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wProductType:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wReserved:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->wReserved)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wReserved:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, wReserved)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wReserved = all_bits_set;
        is_unsigned = fieldHolder.wReserved > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wReserved:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMajor:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->wServicePackMajor)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMajor:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, wServicePackMajor)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wServicePackMajor = all_bits_set;
        is_unsigned = fieldHolder.wServicePackMajor > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMajor:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMinor:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->wServicePackMinor)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMinor:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, wServicePackMinor)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wServicePackMinor = all_bits_set;
        is_unsigned = fieldHolder.wServicePackMinor > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wServicePackMinor:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wSuiteMask:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((OSVERSIONINFOEXA *) 0)->wSuiteMask)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wSuiteMask:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(OSVERSIONINFOEXA, wSuiteMask)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        OSVERSIONINFOEXA fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wSuiteMask = all_bits_set;
        is_unsigned = fieldHolder.wSuiteMask > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:OSVERSIONINFOEXA:StructFieldInfo:wSuiteMask:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:PCONDITION_VARIABLE:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PCONDITION_VARIABLE)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:PCRITICAL_SECTION:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(PCRITICAL_SECTION)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(SYSTEM_INFO)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwActiveProcessorMask:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->dwActiveProcessorMask)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwActiveProcessorMask:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, dwActiveProcessorMask)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwActiveProcessorMask = all_bits_set;
        is_unsigned = fieldHolder.dwActiveProcessorMask > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwActiveProcessorMask:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwAllocationGranularity:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->dwAllocationGranularity)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwAllocationGranularity:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, dwAllocationGranularity)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwAllocationGranularity = all_bits_set;
        is_unsigned = fieldHolder.dwAllocationGranularity > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwAllocationGranularity:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwNumberOfProcessors:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->dwNumberOfProcessors)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwNumberOfProcessors:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, dwNumberOfProcessors)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwNumberOfProcessors = all_bits_set;
        is_unsigned = fieldHolder.dwNumberOfProcessors > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwNumberOfProcessors:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwPageSize:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->dwPageSize)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwPageSize:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, dwPageSize)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwPageSize = all_bits_set;
        is_unsigned = fieldHolder.dwPageSize > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwPageSize:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwProcessorType:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->dwProcessorType)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwProcessorType:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, dwProcessorType)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwProcessorType = all_bits_set;
        is_unsigned = fieldHolder.dwProcessorType > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:dwProcessorType:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:lpMaximumApplicationAddress:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->lpMaximumApplicationAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:lpMaximumApplicationAddress:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, lpMaximumApplicationAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:lpMinimumApplicationAddress:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->lpMinimumApplicationAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:lpMinimumApplicationAddress:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, lpMinimumApplicationAddress)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorArchitecture:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->wProcessorArchitecture)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorArchitecture:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, wProcessorArchitecture)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wProcessorArchitecture = all_bits_set;
        is_unsigned = fieldHolder.wProcessorArchitecture > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorArchitecture:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorLevel:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->wProcessorLevel)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorLevel:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, wProcessorLevel)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wProcessorLevel = all_bits_set;
        is_unsigned = fieldHolder.wProcessorLevel > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorLevel:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorRevision:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->wProcessorRevision)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorRevision:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, wProcessorRevision)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wProcessorRevision = all_bits_set;
        is_unsigned = fieldHolder.wProcessorRevision > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wProcessorRevision:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wReserved:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((SYSTEM_INFO *) 0)->wReserved)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wReserved:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(SYSTEM_INFO, wReserved)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        SYSTEM_INFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.wReserved = all_bits_set;
        is_unsigned = fieldHolder.wReserved > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:SYSTEM_INFO:StructFieldInfo:wReserved:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(VS_FIXEDFILEINFO)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateLS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileDateLS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateLS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileDateLS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileDateLS = all_bits_set;
        is_unsigned = fieldHolder.dwFileDateLS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateLS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateMS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileDateMS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateMS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileDateMS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileDateMS = all_bits_set;
        is_unsigned = fieldHolder.dwFileDateMS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileDateMS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlags:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileFlags)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlags:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileFlags)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileFlags = all_bits_set;
        is_unsigned = fieldHolder.dwFileFlags > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlags:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlagsMask:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileFlagsMask)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlagsMask:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileFlagsMask)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileFlagsMask = all_bits_set;
        is_unsigned = fieldHolder.dwFileFlagsMask > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileFlagsMask:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileOS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileOS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileOS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileOS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileOS = all_bits_set;
        is_unsigned = fieldHolder.dwFileOS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileOS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileSubtype:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileSubtype)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileSubtype:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileSubtype)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileSubtype = all_bits_set;
        is_unsigned = fieldHolder.dwFileSubtype > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileSubtype:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileType:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileType)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileType:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileType)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileType = all_bits_set;
        is_unsigned = fieldHolder.dwFileType > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileType:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionLS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileVersionLS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionLS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileVersionLS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileVersionLS = all_bits_set;
        is_unsigned = fieldHolder.dwFileVersionLS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionLS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionMS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwFileVersionMS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionMS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwFileVersionMS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwFileVersionMS = all_bits_set;
        is_unsigned = fieldHolder.dwFileVersionMS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwFileVersionMS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionLS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwProductVersionLS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionLS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwProductVersionLS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwProductVersionLS = all_bits_set;
        is_unsigned = fieldHolder.dwProductVersionLS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionLS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionMS:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwProductVersionMS)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionMS:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwProductVersionMS)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwProductVersionMS = all_bits_set;
        is_unsigned = fieldHolder.dwProductVersionMS > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwProductVersionMS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwSignature:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwSignature)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwSignature:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwSignature)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwSignature = all_bits_set;
        is_unsigned = fieldHolder.dwSignature > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwSignature:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwStrucVersion:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(((VS_FIXEDFILEINFO *) 0)->dwStrucVersion)));
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwStrucVersion:PropertyInfo:offset=%llu\n", ((unsigned long long)offsetof(VS_FIXEDFILEINFO, dwStrucVersion)));
    {
        int is_unsigned;
        unsigned long long all_bits_set = -1;
        VS_FIXEDFILEINFO fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.dwStrucVersion = all_bits_set;
        is_unsigned = fieldHolder.dwStrucVersion > 0;
        printf("NativeCodeInfo:WindowsDirectives:StructInfo:VS_FIXEDFILEINFO:StructFieldInfo:dwStrucVersion:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:WindowsDirectives:StructInfo:WSADATA:PropertyInfo:size=%llu\n", ((unsigned long long)sizeof(WSADATA)));
    return 0;
}

int main(void) {
    return WindowsDirectives();
}
