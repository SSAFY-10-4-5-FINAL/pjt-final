<script setup>
import { ref, onMounted, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useApartStore } from "@/stores/apartStore";

const route = useRoute();
const router = useRouter();
const apartStore = useApartStore();

onMounted(() => {
  apartStore.fetchApartByAptCode(aptCode);
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
const dealList = ref([]);
// private String dealAmount;
// 	private int dealYear;
// 	private int dealMonth;
// 	private String area;
// 	private String floor;

watch(
  () => apartStore.apartList,
  (newApartList) => {
    if (newApartList.length > 0) {
      apart.value = newApartList[0];
    }
  }
);
watch(
  () => apartStore.dealList,
  (newDealList) => {
    dealList.value = newDealList[0];
  }
);

// Method
</script>
<template>
  <div id="detail-wrap">
    <div class="apart-content" style="text-align: center">
      <h2>{{ apart.apartmentName }}</h2>
      <div>
        {{ apart.sidoName + " " + apart.gugunName }}
      </div>
      <div>
        {{ apart.roadName }}
      </div>
      <div style="margin-left: 10px">조회수: {{ apart.hit }}</div>
    </div>
    <div style="margin-top: 20px">
      <h5>최근 거래</h5>
      <div v-for="deal in dealList" class="deal-list-item">
        <div>
          {{ deal.dealYear }}년 {{ deal.dealMonth }}월 &nbsp;
          {{ deal.dealAmount }}&nbsp;(단위: 천 원)
        </div>
        <div>{{ deal.floor }}층 &nbsp; 면적: {{ deal.area }}</div>
      </div>
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
  text-align: center;
}

.deal-list-item {
  border-bottom: 0.3px solid #708090;
}
</style>
