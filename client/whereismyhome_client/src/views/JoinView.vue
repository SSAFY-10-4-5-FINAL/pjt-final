<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/authStore";
import TheFooter from "@/components/layouts/TheFooter.vue";

const route = useRoute();
const router = useRouter();
const authStore = useAuthStore();

const registerUser = ref({
  loginId: "",
  password: "",
  role: "USER",
  nickname: "",
  openAgreement: 1,
});

const onRegister = async () => {
  await authStore.fetchRegister(registerUser.value);
  alert("회원가입이 완료되었습니다.");
  router.push({ name: "MainView" });
};
</script>

<template>
  <div class="join-view-wrap">
    <div class="join-form-wrap">
      <div class="join-form">
        <div id="join-text-area">
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <!-- 중간 정렬을 위한 추가된 div -->
            <div class="col-sm-8">
              <!-- 수정된 부분 -->
              <input
                type="text"
                class="form-control"
                v-model="registerUser.loginId"
                placeholder="아이디" />
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                id="inputPassword3"
                v-model="registerUser.password"
                placeholder="비밀번호" />
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <input
                type="text"
                class="form-control"
                v-model="registerUser.nickname"
                placeholder="닉네임" />
            </div>
          </div>
        </div>
        <fieldset class="form-group">
          <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <legend class="col-form-label"><h6>프로필 공개 여부</h6></legend>
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios1"
                  value="1"
                  v-model="registerUser.openAgreement"
                  checked />
                <label class="form-check-label" for="gridRadios1"> 동의 </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios2"
                  value="0"
                  v-model="registerUser.openAgreement" />
                <label class="form-check-label" for="gridRadios2"> 비동의 </label>
              </div>
            </div>
          </div>
        </fieldset>
        <div class="form-group row" id="join-submit-btn-wrap">
          <div class="col-sm-2"></div>
          <div class="col-sm-8">
            <button class="btn join-submit-btn" @click="onRegister">Join</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <TheFooter />
</template>

<style scoped>
.join-view-wrap {
  padding: 200px;
}
.join-form-wrap {
  border: 2px solid black;
  display: flex;
  padding: 50px;
  justify-content: center; /* 수평 가운데 정렬 */
}

.join-form {
  width: 100%;
}

.join-form .row {
  margin: 20px;
}

.join-form #join-text-area input {
  height: 60px;
}

.join-form #join-submit-btn-wrap {
  text-align: right;
}

.join-submit-btn {
  background-color: rgba(238, 234, 12, 0.822);
  color: #4d5964;
}
</style>
