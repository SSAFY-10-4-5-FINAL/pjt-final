export default [
  {
    path: "write",
    name: "article-write",
    // component: () => import("@/components/boards/BoardWrite.vue"),
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
