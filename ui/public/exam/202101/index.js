(function () {
  let app;
  let appAdd;
  let appModify;

  let divToast = document.getElementById('div-toast');
  let myToast = bootstrap.Toast.getOrCreateInstance(divToast);
  let divToasInfo = document.querySelector('#div-toast .toast-body');
  let addDialog = document.getElementById('add-dialog');
  let bsAddDialog;

  let modifyInfo;
  let modifyDialog = document.getElementById('modify-dialog');
  let bsModifyDialog;

  new Vue({
    el: '#app',
    data() {
      return {
        title: '商品管理系统',
        page: { pageSize: 5 },
        queryInfo: { typeId: -1 },
        list: [],
        typeList: [],
      };
    },
    mounted() {
      bsAddDialog = bootstrap.Modal.getOrCreateInstance(addDialog);
      bsModifyDialog = bootstrap.Modal.getOrCreateInstance(modifyDialog);
    },
    methods: {
      showModify(info) {
        modifyInfo = JSON.parse(JSON.stringify(info));
        bsModifyDialog.show();
      },
      del(info) {
        if (confirm('是否删除商品：' + info.goodsName)) {
          ajax(
            '/exam/goods/delete',
            {
              'tbGoods.goodsId': info.goodsId,
            },
            function (data) {
              alert(data.message);
              app.query();
            }
          );
        }
      },
      showAdd() {
        bsAddDialog.show();
      },
      nextPage() {
        app.page.pageNumber++;
        app.query();
      },
      prePage() {
        app.page.pageNumber--;
        app.query();
      },
      toPage(pn) {
        app.page.pageNumber = pn;
        app.query();
      },
      showToast(info) {
        divToasInfo.innerHTML = info;
        myToast.show();
      },
      showType(typeId) {
        for (let i = 0; i < app.typeList.length; i++) {
          let type = app.typeList[i];
          if (type.typeId == typeId) {
            return type.typeName;
          }
        }
        return '';
      },
      showTime(date) {
        return formatTimestamp(date);
      },
      reset() {
        app.page = { pageSize: 5 };
        app.queryInfo = { typeId: -1 };
        app.query();
      },
      query() {
        ajax(
          '/exam/goods/queryAll',
          {
            page: app.page,
            tbGoods: app.queryInfo,
          },
          function (data) {
            if (data.success) {
              app.page = data.resultData.page;
              app.list = data.resultData.list;
              app.typeList = data.resultData.typeList;
            } else {
              app.showToast(data.message);
            }
          }
        );
      },
    },
    created() {
      app = this;
      app.query();
    },
  });

  new Vue({
    el: '#addForm',
    data() {
      return {
        addInfo: {},
        typeList: [],
        info: '',
      };
    },
    methods: {
      add() {
        ajax(
          '/exam/goods/add',
          {
            tbGoods: appAdd.addInfo,
          },
          function (data) {
            appAdd.info = data.message;
          }
        );
      },
    },
    created() {
      appAdd = this;
    },
  });

  addDialog.addEventListener('shown.bs.modal', function () {
    appAdd.typeList = app.typeList;
    appAdd.addInfo.typeId = app.typeList[0].typeId;
  });

  addDialog.addEventListener('hidden.bs.modal', function () {
    appAdd.info = '';
    app.query();
  });

  new Vue({
    el: '#modifyForm',
    data() {
      return {
        modifyInfo: {},
        typeList: [],
        info: '',
      };
    },
    methods: {
      modify() {
        ajax(
          '/exam/goods/update',
          {
            tbGoods: appModify.modifyInfo,
          },
          function (data) {
            appModify.info = data.message;
          }
        );
      },
    },
    created() {
      appModify = this;
    },
  });

  modifyDialog.addEventListener('shown.bs.modal', function () {
    appModify.typeList = app.typeList;
    appModify.modifyInfo = modifyInfo;
  });

  modifyDialog.addEventListener('hidden.bs.modal', function () {
    appModify.info = '';
    app.query();
  });
})();
