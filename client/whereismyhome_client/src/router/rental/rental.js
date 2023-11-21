export default [
  {
    path: "write",
    name: "RentalWrite",
    component: () => import("@/components/rental/RentalWrite.vue"),
  },
  {
    path: "list",
    name: "RentalList",
    component: () => import("@/components/rental/RentalList.vue"),
  },
  {
    path: ":rentalNo",
    name: "RentalDetail",
    component: () => import("@/components/rental/RentalDetail.vue"),
  },

  {
    path: ":rentalNo",
    name: "RentalModify",
    component: () => import("@/components/rental/RentalModify.vue"),
  },
];
