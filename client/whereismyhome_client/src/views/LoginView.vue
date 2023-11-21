<script setup>
import TheFooter from "@/components/layouts/TheFooter.vue";
</script>

<template>
  <div class="join-view-wrap">
    <div class="join-form-wrap">
      <form class="join-form">
        <h2>로그인</h2>
        <div class="form-group row">
          <div class="col-sm-2"></div>
          <div class="col-sm-8">
            <!-- 수정된 부분 -->
            <input type="text" class="form-control" placeholder="아이디" />
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-2"></div>
          <div class="col-sm-8">
            <input
              type="password"
              class="form-control"
              id="inputPassword3"
              placeholder="비밀번호" />
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-2"></div>
          <div class="col-sm-8">
            <button type="submit" class="btn login-btn">로그인</button>
          </div>
        </div>
      </form>
    </div>
    <RouterLink :to="{ name: 'JoinView' }" style="text-decoration: none; color: inherit"
      ><div id="join-btn">회원가입</div></RouterLink
    >
  </div>
  <TheFooter />
</template>

<style scoped>
.join-view-wrap {
  /* padding: 200px; */
  padding-top: 200px;
  padding-bottom: 200px;
  padding-left: 500px;
  padding-right: 500px;
}
.join-form-wrap {
  border: 2px solid black;
  display: flex;
  padding: 50px;
  justify-content: center; /* 수평 가운데 정렬 */
}

.join-form {
  width: 100%;
  text-align: center;
}

.join-form .row {
  margin: 20px;
}

.join-form input {
  height: 60px;
}

.login-btn {
  background-color: rgba(238, 234, 12, 0.822);
  color: #4d5964;
}

#join-btn {
  margin-top: 10px;
  margin-right: 20px;
  text-align: right;
}
</style>
