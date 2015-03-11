$(function(){
    var introguide = introJs();
//    var startbtn   = $('#startdemotour');

    introguide.setOptions({
        steps: [
            {
                element: '#carCapacity',
                intro: 'Укажите сколько пассажиров Вы сможете взять',
                position: 'bottom'
            },
            {
                element: '#cost',
                intro: 'Укажите стоимость поездки',
                position: 'bottom'
            },
            {
                element: '#timePicker',
                intro: 'Установите дату и время поездки',
                position: 'bottom'
            },
            {
                element: '#leftCoast',
                intro: 'Отметьте хотя бы одну точку следования на левом берегу',
                position: 'right'
            },
            {
                element: '#rightCoast',
                intro: "Отметьте хотя бы одну точку следования на правом берегу",
                position: 'bottom'
            },
            {
                element: '#saveTrip',
                intro: "Сохраните свою поездку в базе данных",
                position: 'bottom'
            }
        ]
    });

    introguide.start();


});
