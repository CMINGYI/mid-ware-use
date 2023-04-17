package com.chengming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name: SystemController
 * @Author: kitchening
 * @Date: 2023-04-16 20:57
 * @Description: SystemController
 * @Version: V1.0
 */
@RestController
@RequestMapping("system")
public class SystemController {


    @GetMapping("/userPermission")
    public Object permission() {
        // TODO document why this method is empty
        return "{\n" +
                "  \"user_info\": {\n" +
                "    \"id\": 55,\n" +
                "    \"account\": \"admin\",\n" +
                "    \"nick_name\": \"管理员\",\n" +
                "    \"birthday\": \"\",\n" +
                "    \"sex\": 1,\n" +
                "    \"avatar\": \"\",\n" +
                "    \"email\": \"yuetchn@163.com\",\n" +
                "    \"mobile\": \"\",\n" +
                "    \"sign\": \"\",\n" +
                "    \"reg_ip\": \"\",\n" +
                "    \"status\": 1,\n" +
                "    \"role_ids\": [\n" +
                "      26,\n" +
                "      28\n" +
                "    ],\n" +
                "    \"role_list\": [\n" +
                "      {\n" +
                "        \"id\": 26,\n" +
                "        \"role_code\": \"7b9edb82-7fcd-4bac-b9f9-3f75c8f6e4d5988\",\n" +
                "        \"role_name\": \"管理员\",\n" +
                "        \"remark\": \"管理员（默认拥有所有API权限，不管设置与否）\",\n" +
                "        \"status\": 1,\n" +
                "        \"create_time\": \"2022-12-22 17:35:16\",\n" +
                "        \"update_time\": \"2023-01-10 15:53:29\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 28,\n" +
                "        \"role_code\": \"7b9edb82-7fcd-4bac-b9f9-3f75c8f6e4d99\",\n" +
                "        \"role_name\": \"超级管理员\",\n" +
                "        \"remark\": \"名副其实的（伪）超级管理员\",\n" +
                "        \"status\": 1,\n" +
                "        \"create_time\": \"2023-01-08 22:35:45\",\n" +
                "        \"update_time\": \"2023-01-10 15:53:57\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"create_time\": \"2022-12-04 14:08:04\",\n" +
                "    \"update_time\": \"2023-01-10 15:41:38\"\n" +
                "  },\n" +
                "  \"menus\": [\n" +
                "    {\n" +
                "      \"id\": 20,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"组件展示\",\n" +
                "      \"title\": \"组件展示\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/components\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"component\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 0,\n" +
                "      \"create_time\": \"2022-07-20 13:21:13\",\n" +
                "      \"update_time\": \"2022-07-21 09:49:37\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"组件展示\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"component\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 24,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"dialog\",\n" +
                "          \"title\": \"弹窗\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"dialog\",\n" +
                "          \"component\": \"components/dialog\",\n" +
                "          \"icon\": \"dialog\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:24:11\",\n" +
                "          \"update_time\": \"2022-08-17 09:47:18\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"弹窗\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"dialog\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 23,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"markdownIndex\",\n" +
                "          \"title\": \"MarkDown\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"index\",\n" +
                "          \"component\": \"components/markdown\",\n" +
                "          \"icon\": \"markdown\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:23:10\",\n" +
                "          \"update_time\": \"2022-07-24 14:20:16\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"MarkDown\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"markdown\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 27,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"iconSelect\",\n" +
                "          \"title\": \"icon选择器\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"iconSelect\",\n" +
                "          \"component\": \"components/iconSelect\",\n" +
                "          \"icon\": \"icon\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-25 14:29:04\",\n" +
                "          \"update_time\": \"2022-08-17 09:54:51\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"icon选择器\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"icon\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 22,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"richTextEdit\",\n" +
                "          \"title\": \"富文本编辑器\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"richTextEdit\",\n" +
                "          \"component\": \"components/richTextEdit\",\n" +
                "          \"icon\": \"richText\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:22:32\",\n" +
                "          \"update_time\": \"2022-07-23 09:56:32\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"富文本编辑器\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"richText\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 26,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"linkComponent\",\n" +
                "          \"title\": \"链接\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"linkComponent\",\n" +
                "          \"component\": \"components/Glink\",\n" +
                "          \"icon\": \"link\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:25:37\",\n" +
                "          \"update_time\": \"2022-08-17 09:53:06\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"链接\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"link\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 21,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"tablePage\",\n" +
                "          \"title\": \"表格\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"tablePage\",\n" +
                "          \"component\": \"components/tablePage\",\n" +
                "          \"icon\": \"table\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:22:01\",\n" +
                "          \"update_time\": \"2022-07-20 13:23:41\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"表格\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"table\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 25,\n" +
                "          \"parent_id\": 20,\n" +
                "          \"name\": \"qrCode\",\n" +
                "          \"title\": \"二维码\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"qrCode\",\n" +
                "          \"component\": \"components/qrCode\",\n" +
                "          \"icon\": \"qrCode\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:25:09\",\n" +
                "          \"update_time\": \"2022-07-20 13:25:14\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"二维码\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"qrCode\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 39,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"routerNest\",\n" +
                "      \"title\": \"路由嵌套\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/routerNest\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"module\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 1,\n" +
                "      \"create_time\": \"2022-07-24 12:06:42\",\n" +
                "      \"update_time\": \"2022-08-17 09:54:03\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"路由嵌套\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"module\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 40,\n" +
                "          \"parent_id\": 39,\n" +
                "          \"name\": \"routerNestIndex\",\n" +
                "          \"title\": \"子路由1\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"index\",\n" +
                "          \"component\": \"components/dialog\",\n" +
                "          \"icon\": \"module\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:07:37\",\n" +
                "          \"update_time\": \"2022-08-17 09:53:50\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"子路由1\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"module\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": 42,\n" +
                "              \"parent_id\": 40,\n" +
                "              \"name\": \"routerNestChildren2\",\n" +
                "              \"title\": \"子子路由2\",\n" +
                "              \"type\": 1,\n" +
                "              \"path\": \"routerNestChildren2\",\n" +
                "              \"component\": \"components/dialog\",\n" +
                "              \"icon\": \"module\",\n" +
                "              \"is_affix\": 0,\n" +
                "              \"is_hide\": 0,\n" +
                "              \"is_cache\": 0,\n" +
                "              \"status\": 1,\n" +
                "              \"sort\": 0,\n" +
                "              \"create_time\": \"2022-07-24 12:08:14\",\n" +
                "              \"update_time\": \"2022-08-17 09:52:47\",\n" +
                "              \"meta\": {\n" +
                "                \"title\": \"子子路由2\",\n" +
                "                \"hide\": 0,\n" +
                "                \"icon\": \"module\",\n" +
                "                \"cache\": 0,\n" +
                "                \"button_options\": []\n" +
                "              },\n" +
                "              \"children\": null\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": 41,\n" +
                "              \"parent_id\": 40,\n" +
                "              \"name\": \"routerNestChildrenIndex\",\n" +
                "              \"title\": \"子子路由1\",\n" +
                "              \"type\": 1,\n" +
                "              \"path\": \"routerNestChildrenIndex\",\n" +
                "              \"component\": \"components/dialog\",\n" +
                "              \"icon\": \"module\",\n" +
                "              \"is_affix\": 0,\n" +
                "              \"is_hide\": 0,\n" +
                "              \"is_cache\": 0,\n" +
                "              \"status\": 1,\n" +
                "              \"sort\": 0,\n" +
                "              \"create_time\": \"2022-07-24 12:07:54\",\n" +
                "              \"update_time\": \"2022-08-17 09:50:35\",\n" +
                "              \"meta\": {\n" +
                "                \"title\": \"子子路由1\",\n" +
                "                \"hide\": 0,\n" +
                "                \"icon\": \"module\",\n" +
                "                \"cache\": 0,\n" +
                "                \"button_options\": []\n" +
                "              },\n" +
                "              \"children\": null\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 30,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"permission\",\n" +
                "      \"title\": \"权限\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/permission\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"permission\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 2,\n" +
                "      \"create_time\": \"2022-07-24 12:02:02\",\n" +
                "      \"update_time\": \"2022-08-17 09:50:15\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"权限\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"permission\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 32,\n" +
                "          \"parent_id\": 30,\n" +
                "          \"name\": \"permissionTest2\",\n" +
                "          \"title\": \"菜单权限2\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"test2\",\n" +
                "          \"component\": \"components/permission/test2\",\n" +
                "          \"icon\": \"permission\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:03:31\",\n" +
                "          \"update_time\": \"2022-07-24 12:03:31\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"菜单权限2\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"permission\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 31,\n" +
                "          \"parent_id\": 30,\n" +
                "          \"name\": \"permissionTest\",\n" +
                "          \"title\": \"菜单权限\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"test\",\n" +
                "          \"component\": \"components/permission/test\",\n" +
                "          \"icon\": \"permission\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:02:48\",\n" +
                "          \"update_time\": \"2022-07-24 12:02:48\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"菜单权限\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"permission\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 33,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"icon\",\n" +
                "      \"title\": \"Icon\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/icon\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"icon\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 3,\n" +
                "      \"create_time\": \"2022-07-24 12:04:22\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:00\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"Icon\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"icon\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 34,\n" +
                "          \"parent_id\": 33,\n" +
                "          \"name\": \"iconIndex\",\n" +
                "          \"title\": \"Icon\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"index\",\n" +
                "          \"component\": \"components/icon\",\n" +
                "          \"icon\": \"icon\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:04:43\",\n" +
                "          \"update_time\": \"2022-07-24 12:04:43\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"Icon\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"icon\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 28,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"clipboard\",\n" +
                "      \"title\": \"剪切板\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/clipboard\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"clipboard\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 3,\n" +
                "      \"create_time\": \"2022-07-20 13:29:40\",\n" +
                "      \"update_time\": \"2022-07-24 13:08:01\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"剪切板\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"clipboard\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 29,\n" +
                "          \"parent_id\": 28,\n" +
                "          \"name\": \"clipboardIndex\",\n" +
                "          \"title\": \"剪切板\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"clipboardIndex\",\n" +
                "          \"component\": \"components/clipboard\",\n" +
                "          \"icon\": \"clipboard\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-20 13:30:04\",\n" +
                "          \"update_time\": \"2022-07-22 20:48:25\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"剪切板\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"clipboard\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 43,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"locale\",\n" +
                "      \"title\": \"国际化\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/locale\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"locale\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 4,\n" +
                "      \"create_time\": \"2022-07-24 12:08:46\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:12\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"国际化\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"locale\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 44,\n" +
                "          \"parent_id\": 43,\n" +
                "          \"name\": \"localeIndex\",\n" +
                "          \"title\": \"国际化\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"localeIndex\",\n" +
                "          \"component\": \"components/locale\",\n" +
                "          \"icon\": \"locale\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:09:02\",\n" +
                "          \"update_time\": \"2022-07-24 12:09:02\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"国际化\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"locale\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 35,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"verify\",\n" +
                "      \"title\": \"正则验证\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/verify\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"verify\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 5,\n" +
                "      \"create_time\": \"2022-07-24 12:05:20\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:25\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"正则验证\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"verify\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 36,\n" +
                "          \"parent_id\": 35,\n" +
                "          \"name\": \"verifyIndex\",\n" +
                "          \"title\": \"正则验证\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"verifyIndex\",\n" +
                "          \"component\": \"components/verifys\",\n" +
                "          \"icon\": \"verify\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:05:46\",\n" +
                "          \"update_time\": \"2022-07-24 12:05:46\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"正则验证\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"verify\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 47,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"echarts\",\n" +
                "      \"title\": \"图表\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/echarts\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"echart\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 6,\n" +
                "      \"create_time\": \"2022-07-24 12:10:04\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:30\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"图表\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"echart\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 48,\n" +
                "          \"parent_id\": 47,\n" +
                "          \"name\": \"chartLine\",\n" +
                "          \"title\": \"Line\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"chartLine\",\n" +
                "          \"component\": \"components/echarts/chartLine\",\n" +
                "          \"icon\": \"echart\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:10:27\",\n" +
                "          \"update_time\": \"2022-07-24 12:10:27\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"Line\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"echart\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 49,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"cache\",\n" +
                "      \"title\": \"缓存\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/cache\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"cache\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 7,\n" +
                "      \"create_time\": \"2022-07-24 12:10:45\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:40\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"缓存\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"cache\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 50,\n" +
                "          \"parent_id\": 49,\n" +
                "          \"name\": \"cacheIndex\",\n" +
                "          \"title\": \"缓存\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"cacheIndex\",\n" +
                "          \"component\": \"components/cache\",\n" +
                "          \"icon\": \"cache\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:10:59\",\n" +
                "          \"update_time\": \"2022-07-24 12:10:59\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"缓存\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"cache\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 45,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"exportExcel\",\n" +
                "      \"title\": \"导出Excel\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/exportExcel/exportExcel\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"exportExcel\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 8,\n" +
                "      \"create_time\": \"2022-07-24 12:09:24\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:45\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"导出Excel\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"exportExcel\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 46,\n" +
                "          \"parent_id\": 45,\n" +
                "          \"name\": \"exportExcelIndex\",\n" +
                "          \"title\": \"导出Excel\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"exportExcelIndex\",\n" +
                "          \"component\": \"components/exportExcel\",\n" +
                "          \"icon\": \"exportExcel\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:09:48\",\n" +
                "          \"update_time\": \"2022-07-24 12:09:48\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"导出Excel\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"exportExcel\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 37,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"xss\",\n" +
                "      \"title\": \"Xss注入\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/xss\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"xss\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 9,\n" +
                "      \"create_time\": \"2022-07-24 12:06:11\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:49\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"Xss注入\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"xss\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 38,\n" +
                "          \"parent_id\": 37,\n" +
                "          \"name\": \"xssIndex\",\n" +
                "          \"title\": \"Xss注入\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"index\",\n" +
                "          \"component\": \"components/xss\",\n" +
                "          \"icon\": \"xss\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:07:15\",\n" +
                "          \"update_time\": \"2022-07-24 12:07:15\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"Xss注入\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"xss\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 51,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"error\",\n" +
                "      \"title\": \"错误页面\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/error\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"404\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 10,\n" +
                "      \"create_time\": \"2022-07-24 12:11:24\",\n" +
                "      \"update_time\": \"2022-07-24 13:06:53\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"错误页面\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"404\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 52,\n" +
                "          \"parent_id\": 51,\n" +
                "          \"name\": \"404Index\",\n" +
                "          \"title\": \"404\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"404Index\",\n" +
                "          \"component\": \"404/404\",\n" +
                "          \"icon\": \"404\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-07-24 12:11:39\",\n" +
                "          \"update_time\": \"2022-07-24 12:11:39\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"404\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"404\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 53,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"pdf\",\n" +
                "      \"title\": \"PDF\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/pdf\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"pdf\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 1,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 11,\n" +
                "      \"create_time\": \"2022-07-24 12:11:58\",\n" +
                "      \"update_time\": \"2022-07-26 14:47:54\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"PDF\",\n" +
                "        \"hide\": 1,\n" +
                "        \"icon\": \"pdf\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 54,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"link\",\n" +
                "      \"title\": \"外链\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/link\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"link\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 1,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 12,\n" +
                "      \"create_time\": \"2022-07-24 12:12:21\",\n" +
                "      \"update_time\": \"2022-07-26 14:47:44\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"外链\",\n" +
                "        \"hide\": 1,\n" +
                "        \"icon\": \"link\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 55,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"user\",\n" +
                "      \"title\": \"个人中心\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/user\",\n" +
                "      \"component\": \"components/user\",\n" +
                "      \"icon\": \"\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 1,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 90,\n" +
                "      \"create_time\": \"2022-07-24 12:14:08\",\n" +
                "      \"update_time\": \"2022-07-26 14:47:13\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"个人中心\",\n" +
                "        \"hide\": 1,\n" +
                "        \"icon\": \"\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"parent_id\": 0,\n" +
                "      \"name\": \"systemManage\",\n" +
                "      \"title\": \"系统管理\",\n" +
                "      \"type\": 1,\n" +
                "      \"path\": \"/systemManage\",\n" +
                "      \"component\": \"Layout\",\n" +
                "      \"icon\": \"system\",\n" +
                "      \"is_affix\": 0,\n" +
                "      \"is_hide\": 0,\n" +
                "      \"is_cache\": 0,\n" +
                "      \"status\": 1,\n" +
                "      \"sort\": 9999,\n" +
                "      \"create_time\": \"2022-12-21 15:18:17\",\n" +
                "      \"update_time\": \"2022-12-21 15:18:17\",\n" +
                "      \"meta\": {\n" +
                "        \"title\": \"系统管理\",\n" +
                "        \"hide\": 0,\n" +
                "        \"icon\": \"system\",\n" +
                "        \"cache\": 0,\n" +
                "        \"button_options\": []\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": 5,\n" +
                "          \"parent_id\": 1,\n" +
                "          \"name\": \"apiManage\",\n" +
                "          \"title\": \"API管理\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"apiManage\",\n" +
                "          \"component\": \"systemManage/apiManage\",\n" +
                "          \"icon\": \"api\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 1,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-12-21 15:20:03\",\n" +
                "          \"update_time\": \"2022-12-24 07:57:05\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"API管理\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"api\",\n" +
                "            \"cache\": 1,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 4,\n" +
                "          \"parent_id\": 1,\n" +
                "          \"name\": \"menuManage\",\n" +
                "          \"title\": \"菜单管理\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"menuManage\",\n" +
                "          \"component\": \"systemManage/menuManage\",\n" +
                "          \"icon\": \"menu\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 0,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-12-21 15:19:50\",\n" +
                "          \"update_time\": \"2022-12-23 14:01:20\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"菜单管理\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"menu\",\n" +
                "            \"cache\": 0,\n" +
                "            \"button_options\": [\n" +
                "              {\n" +
                "                \"id\": 10,\n" +
                "                \"name\": \"新增子菜单\",\n" +
                "                \"key\": \"addChildren\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 11,\n" +
                "                \"name\": \"编辑\",\n" +
                "                \"key\": \"edit\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 12,\n" +
                "                \"name\": \"删除\",\n" +
                "                \"key\": \"delete\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 13,\n" +
                "                \"name\": \"保存\",\n" +
                "                \"key\": \"save\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 14,\n" +
                "                \"name\": \"新增按钮\",\n" +
                "                \"key\": \"addBtn\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 15,\n" +
                "                \"name\": \"删除按钮\",\n" +
                "                \"key\": \"deleteBtn\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 16,\n" +
                "                \"name\": \"编辑按钮\",\n" +
                "                \"key\": \"editBtn\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 17,\n" +
                "                \"name\": \"新增\",\n" +
                "                \"key\": \"add\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 3,\n" +
                "          \"parent_id\": 1,\n" +
                "          \"name\": \"roleManage\",\n" +
                "          \"title\": \"角色管理\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"roleManage\",\n" +
                "          \"component\": \"systemManage/roleManage\",\n" +
                "          \"icon\": \"role\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 1,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-12-21 15:19:23\",\n" +
                "          \"update_time\": \"2022-12-24 07:56:59\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"角色管理\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"role\",\n" +
                "            \"cache\": 1,\n" +
                "            \"button_options\": [\n" +
                "              {\n" +
                "                \"id\": 7,\n" +
                "                \"name\": \"新增\",\n" +
                "                \"key\": \"add\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 8,\n" +
                "                \"name\": \"编辑\",\n" +
                "                \"key\": \"edit\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 9,\n" +
                "                \"name\": \"删除\",\n" +
                "                \"key\": \"delete\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"id\": 19,\n" +
                "                \"name\": \"配置权限\",\n" +
                "                \"key\": \"permission\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"parent_id\": 1,\n" +
                "          \"name\": \"userManage\",\n" +
                "          \"title\": \"用户管理\",\n" +
                "          \"type\": 1,\n" +
                "          \"path\": \"userManage\",\n" +
                "          \"component\": \"systemManage/userManage\",\n" +
                "          \"icon\": \"dashboard-count\",\n" +
                "          \"is_affix\": 0,\n" +
                "          \"is_hide\": 0,\n" +
                "          \"is_cache\": 1,\n" +
                "          \"status\": 1,\n" +
                "          \"sort\": 0,\n" +
                "          \"create_time\": \"2022-12-21 15:18:50\",\n" +
                "          \"update_time\": \"2022-12-23 14:01:43\",\n" +
                "          \"meta\": {\n" +
                "            \"title\": \"用户管理\",\n" +
                "            \"hide\": 0,\n" +
                "            \"icon\": \"dashboard-count\",\n" +
                "            \"cache\": 1,\n" +
                "            \"button_options\": []\n" +
                "          },\n" +
                "          \"children\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}
