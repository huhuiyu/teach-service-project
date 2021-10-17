import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const USER_SAVE_KEY = 'teach-service-userinfo';
const emptyUser = function () {
  return { name: '', nickname: '' };
};

function loadUser() {
  try {
    let user = localStorage.getItem(USER_SAVE_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return emptyUser();
  } catch (ex) {
    return emptyUser();
  }
}

const LOGIN_USER_KEY = 'teach-service-login-userinfo';

function saveLoginUserInfo(userinfo) {
  if (userinfo) {
    localStorage.setItem(LOGIN_USER_KEY, JSON.stringify(userinfo));
  }
}

function removeLoginUserInfo() {
  localStorage.removeItem(LOGIN_USER_KEY);
}

function loadLoginUserInfo() {
  try {
    let user = localStorage.getItem(LOGIN_USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return null;
  } catch (ex) {
    return null;
  }
}

const LOGIN_ADMIN_KEY = 'teach-service-login-admininfo';

function saveLoginAdminInfo(userinfo) {
  if (userinfo) {
    localStorage.setItem(LOGIN_ADMIN_KEY, JSON.stringify(userinfo));
  }
}

function removeLoginAdminInfo() {
  localStorage.removeItem(LOGIN_ADMIN_KEY);
}

function loadLoginAdminInfo() {
  try {
    let user = localStorage.getItem(LOGIN_ADMIN_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return null;
  } catch (ex) {
    return null;
  }
}

export default new Vuex.Store({
  state: {
    count: 1,
    userinfo: loadUser(),
    loginUserInfo: loadLoginUserInfo(),
    loginAdminInfo: loadLoginAdminInfo(),
  },
  mutations: {
    increment(state) {
      state.count++;
    },
    updateUser(state, user) {
      state.userinfo = JSON.parse(JSON.stringify(user));
      localStorage.setItem(USER_SAVE_KEY, JSON.stringify(user));
    },
    updateLoginUser(state, user) {
      state.loginUserInfo = JSON.parse(JSON.stringify(user));
      saveLoginUserInfo(user);
    },
    removeLoginUser(state) {
      removeLoginUserInfo();
      state.loginUserInfo = null;
    },
    updateAdminUser(state, user) {
      state.loginAdminInfo = JSON.parse(JSON.stringify(user));
      saveLoginAdminInfo(user);
    },
    removeLoginAdmin(state) {
      removeLoginAdminInfo();
      state.loginAdminInfo = null;
    },
  },
  actions: {
    increment(context) {
      return new Promise(function (resolve, reject) {
        try {
          setTimeout(function () {
            context.commit('increment');
            resolve();
          }, 2000);
        } catch (error) {
          reject(error);
        }
      });
    },
  },
  modules: {},
});
