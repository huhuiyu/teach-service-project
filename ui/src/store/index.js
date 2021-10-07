import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const userSaveKey = 'teach-service-userinfo';
const emptyUser = function () {
  return { name: '', nickname: '' };
};

function loadUser() {
  try {
    let user = localStorage.getItem(userSaveKey);
    if (user) {
      return JSON.parse(user);
    }
    return emptyUser();
  } catch (ex) {
    return emptyUser();
  }
}

export default new Vuex.Store({
  state: {
    count: 1,
    userinfo: loadUser(),
  },
  mutations: {
    increment(state) {
      state.count++;
    },
    updateUser(state, user) {
      state.userinfo = JSON.parse(JSON.stringify(user));
      localStorage.setItem(userSaveKey, JSON.stringify(user));
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
