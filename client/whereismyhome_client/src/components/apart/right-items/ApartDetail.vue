<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getApartByAptCode } from "@/api/apart";

const route = useRoute();
const router = useRouter();

onMounted(() => {
  onGetApartByAptCode();
});

// Data
const aptCode = route.params.aptCode;
const apart = ref({
  aptCode: 0,
  apartmentName: "",
  lat: "",
  lng: "",
  sidoName: "",
  gugunName: "",
  roadName: "",
});

// Method
const onGetApartByAptCode = async () => {
  const response = await getApartByAptCode(aptCode);
  apart.value = response.data.aptDto;
  console.log("아파트", apart.value);
};
</script>
<template>
  <div id="detail-wrap">
    <h2>{{ apart.apartmentName }}</h2>
    <div class="apart-content">
      <div>
        {{ apart.sidoName + " " + apart.gugunName }}
      </div>
      <div>
        {{ apart.roadName }}
      </div>
      <div>조회수: {{ apart.hit }}</div>
    </div>
  </div>
</template>
<style scoped>
#detail-wrap {
  height: 100%;
  width: 100%;
  border: 1px solid #708090;
  margin: 0.5px;
  padding: 4px;
  padding-top: 10px;
  padding-left: 10px;
}

.apart-content {
  text-align: left;
}
</style>
