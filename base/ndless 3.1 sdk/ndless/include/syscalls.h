/****************************************************************************
 * Ndless - Syscalls enumeration
 ****************************************************************************/

#ifndef _SYSCALLS_H_
#define _SYSCALLS_H_

/* OS syscalls.
 * The syscall's name must be prefixed with e_.
 * NEVER change the value of these constants for backward compatibility.
 * Append new syscalls at the end of the list, and increment the enumeration.
 * Don't try to sort the symbols.
 * If a syscall becomes deprecated and is deleted from the list, its value
 * cannot be reused.
 */

// START_OF_LIST (always keep this line before the fist constant, used by mksyscalls.sh)
#define e_fopen 0
#define e_fread 1
#define e_fwrite 2
#define e_fclose 3
#define e_fgets 4
#define e_malloc 5
#define e_free 6
#define e_memset 7
#define e_memcpy 8
#define e_memcmp 9
#define e_printf 10
#define e_sprintf 11
#define e_fprintf 12
#define e_ascii2utf16 13
#define e_TCT_Local_Control_Interrupts 14
#define e_mkdir 15
#define e_rmdir 16
#define e_chdir 17
#define e_stat 18
#define e_unlink 19
#define e_rename 20
#define e_TCC_Terminate_Task 21
#define e_puts 22
#define e_NU_Get_First 23
#define e_NU_Get_Next 24
#define e_NU_Done 25
#define e_strcmp 26
#define e_strcpy 27
#define e_strncat 28
#define e_strlen 29
#define e_show_dialog_box2_ 30
#define e_strrchr 31
#define e__vsprintf 32
#define e_fseek 33
#define e_NU_Current_Dir 34
#define e_read_unaligned_longword 35
#define e_read_unaligned_word 36
#define e_strncpy 37
#define e_isalpha 38
#define e_isascii 39
#define e_isdigit 40
#define e_islower 41
#define e_isprint 42
#define e_isspace 43
#define e_isupper 44
#define e_isxdigit 45
#define e_tolower 46
#define e_atoi 47
#define e_atof 48
#define e_calloc 49
#define e_realloc 50
#define e_strpbrk 51
#define e_fgetc 52
#define e_NU_Set_Current_Dir 53
#define e_fputc 54
#define e_memmove 55
#define e_memrev 56
#define e_strchr 57
#define e_strncmp 58
#define e_keypad_type 59
#define e_freopen 60
#define e_errno_addr 61
#define e_toupper 62
#define e_strtod 63
#define e_strtol 64
#define e_ungetc 65
#define e_strerror 66
#define e_strcat 67
#define e_strstr 68
#define e_fflush 69
#define e_remove 70
#define e_stdin 71
#define e_stdout 72
#define e_stderr 73
#define e_ferror 74
#define e_touchpad_read 75
#define e_touchpad_write 76
#define e_adler32 77
#define e_crc32 78
#define e_crc32_combine 79
#define e_zlibVersion 80
#define e_zlibCompileFlags 81
#define e_deflateInit2_ 82
#define e_deflate 83
#define e_deflateEnd 84
#define e_inflateInit2_ 85
#define e_inflate 86
#define e_inflateEnd 87
#define e_TCC_Current_Task_Pointer 88
#define e_ftell 89
#define e_NU_Open 90
#define e_NU_Close 91
#define e_NU_Truncate 92
#define e__show_msgbox_2b 93
#define e__show_msgbox_3b 94
#define e_opendir 95
#define e_readdir 96
#define e_closedir 97
#define e_luaL_register 98
#define e_luaL_checklstring 99
#define e_luaL_error 100
#define e_luaI_openlib 101
#define e_luaL_getmetafield 102
#define e_luaL_callmeta 103
#define e_luaL_typerror 104
#define e_luaL_argerror 105
#define e_luaL_optlstring 106
#define e_luaL_checknumber 107
#define e_luaL_optnumber 108
#define e_luaL_checkinteger 109
#define e_luaL_optinteger 110
#define e_luaL_checkstack 111
#define e_luaL_checktype 112
#define e_luaL_checkany 113
#define e_luaL_newmetatable 114
#define e_luaL_checkudata 115
#define e_luaL_where 116
#define e_luaL_checkoption 117
#define e_luaL_ref 118
#define e_luaL_unref 119
#define e_luaL_loadfile 120
#define e_luaL_loadbuffer 121
#define e_luaL_loadstring 122
#define e_luaL_newstate 123
#define e_luaL_gsub 124
#define e_luaL_findtable 125
#define e_luaL_buffinit 126
#define e_luaL_prepbuffer 127
#define e_luaL_addlstring 128
#define e_luaL_addstring 129
#define e_luaL_addvalue 130
#define e_luaL_pushresult 131
#define e_lua_newstate 132
#define e_lua_close 133
#define e_lua_newthread 134
#define e_lua_atpanic 135
#define e_lua_gettop 136
#define e_lua_settop 137
#define e_lua_pushvalue 138
#define e_lua_remove 139
#define e_lua_insert 140
#define e_lua_replace 141
#define e_lua_checkstack 142
#define e_lua_xmove 143
#define e_lua_isnumber 144
#define e_lua_isstring 145
#define e_lua_iscfunction 146
#define e_lua_isuserdata 147
#define e_lua_type 148
#define e_lua_typename 149
#define e_lua_equal 150
#define e_lua_rawequal 151
#define e_lua_lessthan 152
#define e_lua_tonumber 153
#define e_lua_tointeger 154
#define e_lua_toboolean 155
#define e_lua_tolstring 156
#define e_lua_objlen 157
#define e_lua_tocfunction 158
#define e_lua_touserdata 159
#define e_lua_tothread 160
#define e_lua_topointer 161
#define e_lua_pushnil 162
#define e_lua_pushnumber 163
#define e_lua_pushinteger 164
#define e_lua_pushlstring 165
#define e_lua_pushstring 166
#define e_lua_pushvfstring 167
#define e_lua_pushfstring 168
#define e_lua_pushcclosure 169
#define e_lua_pushboolean 170
#define e_lua_gettable 171
#define e_lua_getfield 172
#define e_lua_rawget 173
#define e_lua_rawgeti 174
#define e_lua_createtable 175
#define e_lua_newuserdata 176
#define e_lua_getmetatable 177
#define e_lua_getfenv 178
#define e_lua_settable 179
#define e_lua_setfield 180
#define e_lua_rawset 181
#define e_lua_rawseti 182
#define e_lua_setmetatable 183
#define e_lua_setfenv 184
#define e_lua_call 185
#define e_lua_pcall 186
#define e_lua_cpcall 187
#define e_lua_load 188
#define e_lua_dump 189
#define e_lua_yield 190
#define e_lua_resume 191
#define e_lua_status 192
#define e_lua_gc 193
#define e_lua_error 194
#define e_lua_next 195
#define e_lua_concat 196
#define e_lua_getstack 197
#define e_refresh_homescr 198
#define e_refresh_docbrowser 199
#define e_strtok 200
#define e_utf162ascii 201
#define e_utf16_strlen 202
#define e__show_1NumericInput 203
#define e__show_2NumericInput 204
#define e__show_msgUserInput 205
#define e_rand 206
#define e_srand 207
#define e_strtoul 208
#define e_string_new 209
#define e_string_free 210
#define e_string_to_ascii 211
#define e_string_lower 212
#define e_string_charAt 213
#define e_string_concat_utf16 214
#define e_string_set_ascii 215
#define e_string_set_utf16 216
#define e_string_indexOf_utf16 217
#define e_string_last_indexOf_utf16 218
#define e_string_compareTo_utf16 219
#define e_string_substring 220
#define e_string_erase 221
#define e_string_truncate 222
#define e_string_substring_utf16 223
#define e_string_insert_replace_utf16 224
#define e_string_insert_utf16 225
#define e_string_sprintf_utf16 226

// END_OF_LIST (always keep this line after the last constant, used by mksyscalls.sh)

// Must be kept up-to-date with the value of the last syscall
#define __SYSCALLS_LAST 226

// Flag: 3 higher bits of the 3-bytes comment field of the swi instruction
#define __SYSCALLS_ISEXT 0x200000
#define __SYSCALLS_ISEMU 0x400000
/* Access to OS variables */
#define __SYSCALLS_ISVAR 0x800000

/* Ndless extensions.
 * Not automatically parsed. Starts from 0. The recommandations for the standard syscalls enumeration apply.
 * The order is the same as in arm/syscalls.c/sc_ext_table[]
 * Must always be or-ed with __SYSCALLS_ISEXT
 * The extensions cannot be called in thumb state (the swi number is too high for the swi thumb instruction */
#define e_nl_osvalue (__SYSCALLS_ISEXT | 0)
#define e_nl_relocdatab (__SYSCALLS_ISEXT | 1)
#define e_nl_hwtype (__SYSCALLS_ISEXT | 2)
#define e_nl_isstartup (__SYSCALLS_ISEXT | 3)
#define e_nl_lua_getstate (__SYSCALLS_ISEXT | 4)
#define e_nl_set_resident (__SYSCALLS_ISEXT | 5)
#define e_nl_ndless_rev (__SYSCALLS_ISEXT | 6)

// Must be kept up-to-date with the value of the last syscalls extension without __SYSCALLS_ISEXT
#define __SYSCALLS_LASTEXT 6

/* Ndless integration with emulators. Grouped to make the integration easier for the emulators (they require
 * only these constants).
 * Not automatically parsed. Starts from 0. The recommandations for the standard syscalls enumeration apply.
 * The order is the same as in arm/emu.c/emu_sysc_table[]
 * Must always be or-ed with __SYSCALLS_ISEMU */
#define NDLSEMU_DEBUG_ALLOC (__SYSCALLS_ISEMU | 0)
#define NDLSEMU_DEBUG_FREE (__SYSCALLS_ISEMU | 1)

// Must be kept up-to-date with the value of the last emu extension without __SYSCALLS_ISEMU
#define __SYSCALLS_LASTEMU 1

#endif
