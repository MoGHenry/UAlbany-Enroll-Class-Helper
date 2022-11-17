const urls = 'https://webapi20221031145639.azurewebsites.net/api/todoitems';
function getJson(url) {
    fetch(url)
    .then((response) => response.json())
    .then((data) => {
        // data = mergeClassTimes(data);
        addClassDiv(data);});
}
// offline test mode
// function getJson(url) {
//     const data = {
//         "id": 0,
//         "number": 2,
//         "value": "[{\"level\":\"Undergraduate\",\"department\":\"Africana Studies\",\"classNumber\":6882,\"courseInfo\":\"AAFS 101 Intro to Africana Studies\",\"meetingTime\":\"TTH 04:30_PM-05:50_PM\",\"meetingLocation\":\"Humanities 024 Agum,David\",\"prerequest\":\"\",\"labrequest\":\"\",\"creditRange\":\"3.0- 3.0\",\"classType\":\"\",\"seatsRemain\":0,\"session\":\"FULL\",\"courseDelivery\":\"INPERSON\",\"genEd\":\"CHALLENGES\",\"specialRestriction\":\"None\",\"description\":\"This course will introduce students to the historical foundations of Africana Studies and discuss its relevance to contemporary society. An interdisciplinary approach will be incorporated as History, Philosophy, Literature, Performing Arts, Sociology, Psychology, Religion/Spirituality, and Anthropology are employed to provide students a detailed analysis of people of African descent in the Western Hemisphere. \",\"other\":\"\"},{\"level\":\"Undergraduate\",\"department\":\"Africana Studies\",\"classNumber\":9752,\"courseInfo\":\"AAFS 150 Life In The Third World\",\"meetingTime\":\"12:00_AM-12:00_AM\",\"meetingLocation\":\"Online Agum,David\",\"prerequest\":\"\",\"labrequest\":\"\",\"creditRange\":\"3.0- 3.0\",\"classType\":\"\",\"seatsRemain\":0,\"session\":\"8W2\",\"courseDelivery\":\"ONLASYNCH/ONLFULL\",\"genEd\":\"INTLPER\",\"specialRestriction\":\"None\",\"description\":\"Introduction to cultural variation and fragmentation among third-world developing communities. Some lectures and discussions are led by third-world graduate students. Whenever possible, distinguished visitors from third-world countries are also involved in the course.\",\"other\":\"\"}]"
//     };
//     addClassDiv(data);
// }