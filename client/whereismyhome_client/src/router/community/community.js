export default [
  {
    path: "write",
    name: "CommunityWrite",
    component: () => import("@/components/community/CommunityWrite.vue"),
  },
  {
    path: "list",
    name: "CommunityList",
    component: () => import("@/components/community/CommunityList.vue"),
  },
  {
    path: "view/:articleno",
    name: "article-view",
    // component: () => import("@/components/boards/BoardDetail.vue"),
  },

  {
    path: "modify/:articleno",
    name: "article-modify",
    // component: () => import("@/components/boards/BoardModify.vue"),
  },
];
