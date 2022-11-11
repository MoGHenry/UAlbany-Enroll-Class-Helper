document.getElementById('header').innerHTML+= "" +
    "<div id=\"cart-div\">\n" +
    "        <form action=\"./cart.html\" >\n" +
    "            <input id=\"hide-cart-item\" type=\"text\" name=\"cart-item\" value=\"\"\n" +
    "                   style=\"display: none;\">\n" +
    "            <input type=\"image\" src=\"../Pic/shopping-cart.png\" alt=\"Submit\" width=\"48\"\n" +
    "                   height=\"48\">\n" +
    "        </form>\n" +
    "    </div>\n" +
    "\n" +
    "    <p id=\"title-p\">hello</p>\n" +
    "\n" +
    "    <div class=\"nav-container\">\n" +
    "        <nav>\n" +
    "            <ul>\n" +
    "<!--                <li><img src=\"./../Pic/cat.jpg\" style=\"display: inline-block;\"></li>-->\n" +
    "                <li><a href=\"../../../index.html\">Home</a></li>\n" +
    "                <li><a href=\"./search_subject.html\">Search Subject</a></li>\n" +
    "                <li><a href=\"./cart.html\">Schedule Planner</a></li>\n" +
    "\n" +
    "            </ul>\n" +
    "        </nav>\n" +
    "\n" +
    "    </div>";

document.getElementById('title-p').innerHTML = document.title;