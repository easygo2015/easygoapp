<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
  <div class="col-lg-12 col-xs-12">
    <div class="bs-component">
      <div class="panel panel-default">
        <div class="panel-body">
          <h2>Добро пожаловать!</h2>

          <p>
            Вы живете в восхитительном городе Днепродзержинске на левом берегу?
            Если ответ утвердительный, значит, благодаря данному сайту, вы сможете значительно облегчить
            себе жизнь.
          </p>

          <h3>Итак, чем же мы Вас сможем заинтересовать?</h3>

          <p>
            Вы наверняка знаете, какие «прекрасные» очереди необходимо простоять на маршрутку, чтобы уехать
            на правый
            берег в утреннее время.
            Главная задача нашего сервиса – облегчить жизнь:
            Тому, кто добирается утром на работу на маршрутках.
            Больше Вам не нужно будет вставать на час раньше, чтобы простоять «Великую» очередь на маршрутку
            и уехать
            на правый берег.
            Тому, кто добирается на правый берег на личном авто без попутчиков.
          </p>

          <h3>Что мы предлагаем?</h3>
          <h4>Зарегистрировавшись на нашем сайте. Вы сможете:</h4>

          <p>
            Находить поездки в нужное для Вас время. Также Вы сможете указывать наиболее популярные места
            посадки и
            высадки пассажиров на левом и правом берегах нашего города, что значительно облегчит Ваш поиск с
            выбором
            поездки.
            В случае, если у Вас есть авто, создавать поездки. При этом Вы сможете выбрать основные точки
            Вашего
            маршрута,
            задавать время старта, устанавливать количество свободных мест в каждой поездке, а также
            адекватную
            стоимость проезда.
            Благодаря этому Вы сможете не только окупить проезд на правый берег, но также помочь людям
            добраться
            вовремя на работу.
            Кто знает, может Вы сможете найти попутчиков, которые проживают по соседству с Вами.
          </p>
          <br><br>

          <div class="row">
            <div class="col-lg-6 col-xs-12">
              <a href="/">
                <button type="button" class="btn btn-primary btn-md">Вернуться на главную</button>
              </a>

              <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
              <a href="/registration">
                <button type="button" class="btn btn-primary btn-md">Зарегистрироваться прямо сейчас</button>
              </a>
              </sec:authorize>
            </div>
            <div class="col-lg-6 col-xs-12">
              <p align="right">С наилучшими пожеланиями: команда разработчиков
                Luxoft CJP 2015</p>

              <p align="right">Stanislav Markov / Kirill Kolesnikov / Valerii
                Babenko / Maria Mitrofanova</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>