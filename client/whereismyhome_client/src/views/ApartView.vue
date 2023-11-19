<script setup>
import ApartNav from "../components/apart/ApartNav.vue";
import ApartMapView from "../components/apart/ApartMapView.vue";
import ApartRightView from "@/components/apart/ApartRightView.vue";
</script>

<template>
  <ApartNav />
  <div class="container-fluid">
    <div class="item"><ApartMapView /></div>
    <div class="item"><RouterView /></div>
  </div>
</template>

<style scoped>
.container-fluid {
  display: grid;
  padding: 0px;
  height: 84vh;
}

.item:nth-child(1) {
  /* 1번 라인에서 11 */
  grid-column-start: 1;
  grid-column-end: 11;
}
.item:nth-child(2) {
  /* 11번 라인에서 12 */
  grid-column-start: 11;
  grid-column-end: 12;
}
</style>
