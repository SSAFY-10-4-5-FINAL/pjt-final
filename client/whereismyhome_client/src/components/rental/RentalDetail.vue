<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/authStore";
import { detailRentalArticle, deleteRentalArticle } from "@/api/rental";

const route = useRoute();
const router = useRouter();

const { articleNo } = route.params; // list에서 router link를 통해 받아온 params

const authStore = useAuthStore();

const article = ref({});

onMounted(() => {
  getRentalArticle();
});

const getRentalArticle = async () => {
  const response = await detailRentalArticle(articleNo);
  article.value = response.data;
  console.log(article.value);
};

function moveRentalList() {
  router.push({ name: "RentalList" });
}

function moveRentalModify() {
  router.push({ name: "RentalModify", params: { articleNo } });
}

async function onDeleteRentalArticle() {
  const response = await deleteRentalArticle(articleNo);
  if (response.status == 200) {
    let msg = "글이 삭제되었습니다.";
    alert(msg);
    router.push({ name: "RentalList" });
  }
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 text-center">게시글 보기</h2>
      </div>
      <div class="col-lg-10 text-start">
        <div class="row my-2">
          <h2 class="text-secondary px-5">{{ article.subject }}</h2>
        </div>
        <div class="row">
          <div class="col-md-8">
            <div class="clearfix align-content-center">
              <img
                class="avatar me-2 float-md-start bg-light p-2"
                src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
              />
              <p>
                <span class="fw-bold">{{ article.userId }}</span> <br />
                <span class="text-secondary fw-light">
                  {{ article.registerTime }} &nbsp; &nbsp; 조회 :
                  {{ article.hit }}
                </span>
              </p>
            </div>
          </div>
          <div class="divider mb-3"></div>
          <div class="text-secondary">{{ article.content }}</div>
          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button type="button" class="btn mb-3" @click="moveRentalList">
              글목록
            </button>
            <button
              type="button"
              class="btn mb-3 ms-1"
              @click="moveRentalModify"
              v-show="article.userId === authStore.loginId"
            >
              글수정
            </button>
            <button
              type="button"
              class="btn mb-3 ms-1"
              @click="onDeleteRentalArticle"
              v-show="article.userId === authStore.loginId"
            >
              글삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
