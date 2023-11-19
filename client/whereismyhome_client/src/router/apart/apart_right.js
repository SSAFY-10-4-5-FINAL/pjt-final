export default [
  {
    path: "right",
    name: "ApartRightView",
    component: () => import("@/components/apart/ApartRightView.vue"),
    redirect: "/apart/right/under",
    children: [
      {
        path: "under",
        name: "ApartRightUnder",
        component: () =>
          import("@/components/apart/right-items/ApartRightUnder.vue"),
        redirect: "apart/right/under/recommend",
        children: [
          {
            path: "recommend",
            component: () =>
              import("@/components/apart/right-items/ApartRecommend.vue"),
          },
          {
            path: "list",
            component: () =>
              import("@/components/apart/right-items/ApartList.vue"),
          },
          {
            path: "detail",
            component: () =>
              import("@/components/apart/right-items/ApartDetail.vue"),
          },
        ],
      },
    ],
  },
];
