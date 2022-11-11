// <div className="session track-Tuesday" style="grid-column: track-2; grid-row: time-1030 / time-1130;">
//     <h3 className="session-title"><a href="#">ICSI 424</a></h3>
//     <span className="session-type">Lecture</span>
//     <span className="session-time">10:30-11:40</span>
//     <span className="session-location">Earth Science 245</span>
//     <span className="session-presenter">Presenter</span>
// </div>

let classList = localStorage;
for(let i=0;i<classList.length;i++)
{
    let class_val = classList.getItem(classList.key(i));
    document.getElementById('class-slot').innerHTML += '' +
        '<div class="session track-Tuesday" style="grid-column: track-2; grid-row: time-1030 / time-1130;">\n' +
        '    <h3 class="session-title"><a href="#">ICSI 424</a></h3>\n' +
        '    <span class="session-type">Lecture</span>\n' +
        '    <span class="session-time">10:30-11:40</span>\n' +
        '    <span class="session-location">Earth Science 245</span>\n' +
        '    <span class="session-presenter">Presenter</span>\n' +
        '  </div>';


}