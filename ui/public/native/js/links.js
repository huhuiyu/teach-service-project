let selProvince = document.getElementById('selProvince');
let selCity = document.getElementById('selCity');
let btnOk = document.getElementById('btnOk');
let divInfo = document.getElementById('divInfo');

let provinceList = [];
let cityList = [];

function loadProvince() {
  serverInfo.ajax('/linkinfo/queryAllProvince', {}, function (data) {
    if (!data.success) {
      divInfo.innerHTML = data.message;
      return;
    }
    provinceList = data.resultData.list;
    if (provinceList.length == 0) {
      divInfo.innerHTML = '没有省份的数据信息';
      return;
    }
    for (let i = 0; i < provinceList.length; i++) {
      let p = provinceList[i];
      let op = document.createElement('option');
      op.append(p.province);
      op.setAttribute('value', p.pid);
      selProvince.appendChild(op);
    }
    selProvince.selectedIndex = provinceList.length / 2;
    loadCity();
  });
}

function loadCity() {
  let pid = selProvince.value;
  if (!pid) {
    divInfo.innerHTML = '没有省份的数据信息';
    return;
  }
  serverInfo.ajax(
    '/linkinfo/queryCityByProvince',
    {
      'tbCity.pid': pid,
    },
    function (data) {
      if (!data.success) {
        divInfo.innerHTML = data.message;
        return;
      }
      selCity.innerHTML = '';
      cityList = data.resultData.list;
      for (let i = 0; i < cityList.length; i++) {
        let c = cityList[i];
        let op = document.createElement('option');
        op.append(c.city);
        op.setAttribute('value', c.cid);
        selCity.appendChild(op);
      }
    }
  );
}

selProvince.addEventListener('change', loadCity);

btnOk.addEventListener('click', function () {
  let p = provinceList[selProvince.selectedIndex];
  let c = cityList[selCity.selectedIndex];
  divInfo.innerHTML = p.province + c.city;
});

loadProvince();

// 图片验证码功能
let imgCode = document.getElementById('imgCode');
let txtCode = document.getElementById('txtCode');
let btnCode = document.getElementById('btnCode');
let divCode = document.getElementById('divCode');
let acode = document.getElementById('acode');

function getImageCode() {
  serverInfo.ajax(
    '/test/imageCode',
    {},
    function (data) {
      if (!data.success) {
        divInfo.innerHTML = data.message;
        return;
      }
      imgCode.setAttribute('src', data.message);
    },
    'get'
  );
}

imgCode.addEventListener('click', getImageCode);
acode.addEventListener('click', getImageCode);

btnCode.addEventListener('click', function () {
  let code = txtCode.value.trim();
  if (code == '') {
    divCode.innerHTML = '请输入验证码';
    return;
  }
  serverInfo.ajax(
    '/test/checkImageCode',
    {
      imageCode: code,
    },
    function (data) {
      divCode.innerHTML = data.success ? '校验码正确' : '校验错误，请更新重试。';
    }
  );
});

getImageCode();
