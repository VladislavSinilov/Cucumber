# language: ru

Функционал: Прикладное администрирование

  Сценарий: Создать правило выполнения сценария
    Дано отправить запрос на получение JWT токена и сохранить в переменную '@JWT_RESPONSE'
      | formParam client_id     | test@app.b2c.vtb.ru                                                            |
      | formParam client_secret | testtest                                                                       |
      | formParam grant_type    | client_credentials                                                             |
      | URL                     | http://st-nt-opers-epa-stub.apps.ds5-genr02.corp.dev.vtb/passport/oauth2/token |

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
      | URL                  | http://intr-st-apigw.apps.ds5-genr02.corp.dev.vtb/db-manager/v1/scriptrules |
      | Content-Type         | application/json                                                            |
      | header Authorization | @JWT_RESPONSE                                                               |
      | JSON                 | @REQUEST                                                                    |


