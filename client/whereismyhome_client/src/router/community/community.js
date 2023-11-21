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
    path: ":communityNo",
    name: "CommunityDetail",
    component: () => import("@/components/community/CommunityDetail.vue"),
  },

  {
    path: ":communityNo",
    name: "CommunityModify",
    component: () => import("@/components/community/CommunityModify.vue"),
  },
];
