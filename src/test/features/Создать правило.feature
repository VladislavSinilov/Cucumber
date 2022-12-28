# language: ru

Функционал: Прикладное администрирование

  Сценарий: Создать правило выполнения сценария
    Дано сохранить ответ в переменную '@EXPECTED_RESPONSE' значение:
            """
"errorCode": "ERR-INTR-newScriptRule-010","errorMessage": "Заполните название сценария"
            """
    Дано сохранить ответ в переменную '@REQUEST' значение:
    """
    {
  "code": "DDD177777",
  "isForBO": true,
  "isForIIS": false,
  "isForStateNew": false,
  "isForStateActive": true,
  "isForStateClosed": false,
  "isForStateBroken": false,
  "isForNoDepo": false,
  "isIgnoreBlackList": false,
  "isFor3dParty": true,
  "isPhoneRequired": true,
  "isEmailRequired": false,
  "isControlPos": true,
  "isControlHQ": true
}
    """
    Если отправить REST запрос методом POST c параметрами и сохранить ответ в переменную 'ACTUAL_RESPONSE'
      | URL                  | http://intr-st-apigw.apps.ds5-genr02.corp.dev.vtb/db-manager/v1/scriptrules                                                                                                                                                                                                                                                                                                                                                                                                             |
      | Content-Type         | application/json                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | header Authorization | Bearer eyJraWQiOiJodHRwczovL3Bhc3Nwb3J0LmFwaS52dGIucnUvcGFzc3BvcnQiLCJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJzdWIiOiJAY29ycC5kZXYudnRiIiwiaXNzIjoiaHR0cHM6Ly9wYXNzcG9ydC5hcGkudnRiLnJ1L3Bhc3Nwb3J0IiwiY2hhbm5lbCI6ImFwaWMiLCJleHAiOjE2NzIyNDkyMjUsImN0eGkiOiI2NDQ1MTE3Zi1lYzFiLTRjM2YtYTZjMy0wMGU0ZTk2N2QxMmQiLCJpYXQiOjE2NzIyNDU2MjUsImp0aSI6ImEwY2U5YWM0LWRmMjMtNDgxMi1iOTg0LTE3MTQxMDI5MmNhNyJ9.HVLGKxlGpAVA9O2NLFFcDuZ3nVjrQ8jIsEPDHhhffiiLS-8NarNK_Dr9zJNgngwm7PDOR2N6-8b7jlgisDyNtw |
      | JSON                 | @REQUEST                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |


