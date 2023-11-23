<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { getUserDetail, deleteUser } from "@/api/admin";

const route = useRoute();
const router = useRouter();

const { loginId } = route.params; // list에서 router link를 통해 받아온 params

console.log(loginId);

const user = ref({});

onMounted(() => {
  getUserDetailOnComponent();
});

const getUserDetailOnComponent = async () => {
  const response = await getUserDetail(loginId);
  user.value = response.data;
  console.log(user.value);
};

function moveUserList() {
  router.push({ name: "AdminView" });
}

function moveUserModify() {
  //   router.push({ name: "NoticeModify", params: { articleNo } });
}

async function onDeleteUser() {
  const response = await deleteUser(loginId);
  if (response.status == 200) {
    let msg = "회원이 삭제되었습니다.";
    alert(msg);
    router.push({ name: "AdminView" });
  }
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10 text-start">
        <div class="row my-2">
          <h2 class="text-secondary px-5">{{ user.loginId }}</h2>
        </div>
        <div class="row">
          <div class="text-secondary">{{ user.nickname }}</div>
          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button type="button" class="btn mb-3" @click="moveUserList">
              회원목록
            </button>
            <button type="button" class="btn mb-3 ms-1" @click="moveUserModify">
              회원수정
            </button>
            <button type="button" class="btn mb-3 ms-1" @click="onDeleteUser">
              회원삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
