<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import ApartMapView from "../components/apart/ApartMapView.vue";

const route = useRoute();
const router = useRouter();

const mapKey = ref(0); // ApartMapView를 새로고침하기 위한 key

watch(
  () => route.path,
  () => {
    mapKey.value++;
  }
);
</script>

<template>
  <!-- <ApartNav /> -->
  <div class="container-fluid">
    <div class="item"><ApartMapView :key="mapKey" /></div>
    <div class="item">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
.container-fluid {
  border-top: 1px solid #4d5964;
  display: grid;
  padding: 0px;
  height: 90vh;
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
  width: 100%;
}
</style>
