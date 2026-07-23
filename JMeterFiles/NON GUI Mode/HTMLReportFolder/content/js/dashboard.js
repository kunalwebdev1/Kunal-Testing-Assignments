/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 54.45, "KoPercent": 45.55};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.0227, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.04625, 500, 1500, "Examples - HTTP Request"], "isController": false}, {"data": [0.0425, 500, 1500, "Product 5 - HTTP Request"], "isController": false}, {"data": [0.02375, 500, 1500, "Personal Loans - HTTP Request"], "isController": false}, {"data": [0.03, 500, 1500, "Product 9 - HTTP Request"], "isController": false}, {"data": [0.02125, 500, 1500, "Login - HTTP Request"], "isController": false}, {"data": [0.01875, 500, 1500, "Inside - HTTP Request"], "isController": false}, {"data": [0.02875, 500, 1500, "Home Page - HTTP Request"], "isController": false}, {"data": [0.005, 500, 1500, "Getting started - HTTP Request"], "isController": false}, {"data": [0.00375, 500, 1500, "Test Practices HTTP Request"], "isController": false}, {"data": [0.02125, 500, 1500, "Inside Investors - HTTP Request"], "isController": false}, {"data": [0.00125, 500, 1500, "Weight Management - HTTP Request"], "isController": false}, {"data": [0.00125, 500, 1500, "Minerals - HTTP Request"], "isController": false}, {"data": [0.005, 500, 1500, "Documentations - WebDriver - HTTP Request"], "isController": false}, {"data": [0.00875, 500, 1500, "IE Driver Server - HTTP Request"], "isController": false}, {"data": [0.01875, 500, 1500, "Business - HTTP Request"], "isController": false}, {"data": [0.075, 500, 1500, "Home Page- HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Selenium Manager - HTTP Request"], "isController": false}, {"data": [0.0375, 500, 1500, "Formulas - HTTP Request"], "isController": false}, {"data": [0.00375, 500, 1500, "Blood Tests - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Offers - HTTP Request"], "isController": false}, {"data": [0.06875, 500, 1500, "Product 1 - HTTP Request"], "isController": false}, {"data": [0.0375, 500, 1500, "FAQ - HTTP Request"], "isController": false}, {"data": [0.03375, 500, 1500, "Product 2 - HTTP Request"], "isController": false}, {"data": [0.00125, 500, 1500, "Chromium - HTTP Request"], "isController": false}, {"data": [0.03375, 500, 1500, "Unit Conversion - HTTP Request"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 10000, 4555, 45.55, 10832.695800000005, 0, 1094716, 2683.5, 29056.19999999999, 47511.349999999984, 97277.52999999998, 5.29150084425896, 306.2583016620472, 0.40611338833054733], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Examples - HTTP Request", 400, 258, 64.5, 5425.425000000001, 0, 90814, 1.0, 14162.200000000006, 44165.39999999996, 90017.56000000001, 0.2155592847311814, 1.9103010115321524, 0.010238013489161141], "isController": false}, {"data": ["Product 5 - HTTP Request", 400, 140, 35.0, 11069.870000000003, 0, 184293, 2823.5, 31671.300000000017, 50146.549999999996, 131088.9600000001, 0.35799885798364306, 4.757369560319228, 0.02976914331768282], "isController": false}, {"data": ["Personal Loans - HTTP Request", 400, 161, 40.25, 7841.294999999994, 0, 113381, 2928.0, 21707.9, 33192.0, 57856.52000000003, 0.3669761804935646, 2.0726171390835137, 0.03361827934731451], "isController": false}, {"data": ["Product 9 - HTTP Request", 400, 141, 35.25, 10861.862500000007, 0, 235089, 3493.5, 26619.0, 45070.399999999994, 135982.57000000004, 0.35975234648467996, 4.673471942071328, 0.029799895907906996], "isController": false}, {"data": ["Login - HTTP Request", 400, 156, 39.0, 10334.25250000002, 0, 95819, 3897.5, 33190.7, 49604.5, 66651.79000000001, 0.36355836384193935, 2.2441358959009703, 0.028154470949868934], "isController": false}, {"data": ["Inside - HTTP Request", 400, 170, 42.5, 10003.275000000003, 0, 179561, 3786.0, 25672.20000000002, 42044.24999999999, 125114.38000000018, 0.3655448400147315, 2.1443667084149336, 0.030584037273693472], "isController": false}, {"data": ["Home Page - HTTP Request", 400, 259, 64.75, 8221.709999999997, 0, 105298, 1.0, 28013.200000000026, 49802.0, 94391.63000000005, 0.212032078333131, 3.825967697840506, 0.00978060080084516], "isController": false}, {"data": ["Getting started - HTTP Request", 400, 135, 33.75, 11002.194999999994, 0, 68919, 6582.0, 28267.600000000002, 43458.94999999999, 62738.20000000003, 0.25342744783987947, 12.982899443433725, 0.02590577939710877], "isController": false}, {"data": ["Test Practices HTTP Request", 400, 147, 36.75, 11899.629999999997, 0, 92082, 6476.5, 29845.5, 45156.99999999998, 73390.46000000006, 0.2532835040253081, 12.296228968762545, 0.022997721675305744], "isController": false}, {"data": ["Inside Investors - HTTP Request", 400, 158, 39.5, 9699.855000000007, 0, 148710, 3600.5, 22550.4, 41575.39999999999, 75222.65000000001, 0.3665212188296611, 2.2011299362390524, 0.03421461260539776], "isController": false}, {"data": ["Weight Management - HTTP Request", 400, 218, 54.5, 11486.947500000011, 0, 243127, 2.0, 27501.00000000004, 43859.34999999998, 168978.80000000028, 0.22740206219560102, 42.76430022309564, 0.015156436274267352], "isController": false}, {"data": ["Minerals - HTTP Request", 400, 222, 55.5, 14139.2825, 0, 330043, 1426.0, 31767.70000000004, 60373.39999999998, 223003.36000000002, 0.22609382780807122, 41.34498508610925, 0.015917093795589702], "isController": false}, {"data": ["Documentations - WebDriver - HTTP Request", 400, 142, 35.5, 12920.88499999999, 0, 82742, 6829.0, 32682.600000000002, 47497.95, 68794.99, 0.24976444091166516, 12.361699526431009, 0.022339770647558023], "isController": false}, {"data": ["IE Driver Server - HTTP Request", 400, 136, 34.0, 14747.872500000003, 0, 198300, 7214.5, 38518.70000000004, 54576.049999999974, 112049.78000000003, 0.2535906856141174, 15.217671199468093, 0.02435362111649639], "isController": false}, {"data": ["Business - HTTP Request", 400, 168, 42.0, 9299.954999999993, 0, 125837, 2706.0, 29819.30000000001, 42047.69999999999, 73509.31000000001, 0.3642337069157054, 2.164776262900703, 0.03115194145671629], "isController": false}, {"data": ["Home Page- HTTP Request", 400, 143, 35.75, 7501.980000000004, 0, 184240, 2402.5, 21620.100000000046, 28825.699999999997, 62784.01, 0.35618719417990125, 1.4384136340666336, 0.02793582425055988], "isController": false}, {"data": ["Selenium Manager - HTTP Request", 400, 137, 34.25, 21496.607500000006, 0, 127773, 13323.0, 58358.80000000001, 77511.44999999998, 102994.5, 0.2532724381967762, 39.8552241813285, 0.024230925379924488], "isController": false}, {"data": ["Formulas - HTTP Request", 400, 256, 64.0, 9007.062500000005, 0, 1094716, 1.0, 11379.500000000005, 25380.69999999996, 90443.19, 0.2151476881305172, 2.055261847678933, 0.010816213852499047], "isController": false}, {"data": ["Blood Tests - HTTP Request", 400, 220, 55.0, 13153.009999999993, 0, 273886, 1.0, 32587.900000000027, 67379.49999999997, 206267.71, 0.24128537545210846, 49.93290864562447, 0.015268840165328739], "isController": false}, {"data": ["Offers - HTTP Request", 400, 206, 51.5, 11410.137499999993, 0, 151879, 835.5, 33044.900000000016, 56982.24999999999, 118859.67000000006, 0.21727239494472317, 37.09894104490097, 0.015436100324442004], "isController": false}, {"data": ["Product 1 - HTTP Request", 400, 127, 31.75, 7435.619999999999, 0, 184230, 2301.5, 20387.300000000007, 32253.44999999999, 61948.46000000002, 0.35845281013561164, 1.5894091644733837, 0.031297235959179395], "isController": false}, {"data": ["FAQ - HTTP Request", 400, 266, 66.5, 11637.634999999998, 0, 1080464, 1.0, 16979.30000000001, 44389.0, 103112.01000000001, 0.21565365160936928, 4.4494192110203326, 0.009736004212794084], "isController": false}, {"data": ["Product 2 - HTTP Request", 400, 125, 31.25, 10545.70000000001, 0, 147724, 3099.0, 33019.80000000001, 54718.94999999998, 100949.75000000009, 0.35944813927177605, 4.841929661952504, 0.031614060589027666], "isController": false}, {"data": ["Chromium - HTTP Request", 400, 209, 52.25, 11903.529999999997, 0, 208842, 602.5, 32260.00000000006, 61694.59999999992, 130083.34000000001, 0.223083199436938, 41.659331136265905, 0.01778837982619588], "isController": false}, {"data": ["Unit Conversion - HTTP Request", 400, 255, 63.75, 7771.800000000002, 0, 900337, 1.0, 18447.90000000004, 38667.34999999999, 90107.28000000017, 0.2130740080605897, 2.127715116355721, 0.011314354676068913], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 84, 1.8441273326015368, 0.84], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 77, 1.690450054884742, 0.77], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 58, 1.2733260153677277, 0.58], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection timed out: connect", 17, 0.3732162458836443, 0.17], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Software caused connection abort: connect", 5, 0.10976948408342481, 0.05], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117] failed: Connection timed out: connect", 1, 0.021953896816684963, 0.01], "isController": false}, {"data": ["Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 2, 0.043907793633369926, 0.02], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 1049, 23.029637760702524, 10.49], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 463, 10.164654226125137, 4.63], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to www.easycalculation.com:443 [www.easycalculation.com/173.255.199.118, www.easycalculation.com/64:ff9b:0:0:0:0:adff:c776] failed: Connection timed out: connect", 1, 0.021953896816684963, 0.01], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 2041, 44.80790340285401, 20.41], "isController": false}, {"data": ["Non HTTP response code: javax.net.ssl.SSLProtocolException/Non HTTP response message: (unexpected_message) Received close_notify during handshake", 1, 0.021953896816684963, 0.01], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.hollandandbarrett.com)", 2, 0.043907793633369926, 0.02], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 62, 1.3611416026344676, 0.62], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.easycalculation.com)", 1, 0.021953896816684963, 0.01], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 17, 0.3732162458836443, 0.17], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 674, 14.796926454445664, 6.74], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 10000, 4555, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 2041, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 1049, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 674, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 463, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 84], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["Examples - HTTP Request", 400, 258, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 211, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 39, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 7, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "", ""], "isController": false}, {"data": ["Product 5 - HTTP Request", 400, 140, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 98, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 23, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 12, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Software caused connection abort: connect", 2], "isController": false}, {"data": ["Personal Loans - HTTP Request", 400, 161, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 101, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 25, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 16, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 14, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3], "isController": false}, {"data": ["Product 9 - HTTP Request", 400, 141, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 98, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 24, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 14, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 5, "", ""], "isController": false}, {"data": ["Login - HTTP Request", 400, 156, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 106, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 27, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 11, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 6, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4], "isController": false}, {"data": ["Inside - HTTP Request", 400, 170, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 102, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 29, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 16, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 12, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection timed out: connect", 5], "isController": false}, {"data": ["Home Page - HTTP Request", 400, 259, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 206, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 39, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 12, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.easycalculation.com)", 1], "isController": false}, {"data": ["Getting started - HTTP Request", 400, 135, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 100, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 32, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3, "", "", "", ""], "isController": false}, {"data": ["Test Practices HTTP Request", 400, 147, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 99, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 44, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "", "", "", ""], "isController": false}, {"data": ["Inside Investors - HTTP Request", 400, 158, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 101, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 13, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 13, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 11, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 9], "isController": false}, {"data": ["Weight Management - HTTP Request", 400, 218, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 138, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 71, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 5, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "", ""], "isController": false}, {"data": ["Minerals - HTTP Request", 400, 222, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 133, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 67, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 11, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 7, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.hollandandbarrett.com)", 2], "isController": false}, {"data": ["Documentations - WebDriver - HTTP Request", 400, 142, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 99, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 38, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Software caused connection abort: connect", 1, "", ""], "isController": false}, {"data": ["IE Driver Server - HTTP Request", 400, 136, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 98, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 34, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "", "", "", ""], "isController": false}, {"data": ["Business - HTTP Request", 400, 168, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 103, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: altoro.testfire.net:80 failed to respond", 30, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 20, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to altoro.testfire.net:80 [altoro.testfire.net/65.61.137.117, altoro.testfire.net/64:ff9b:0:0:0:0:413d:8975] failed: Connection refused: connect", 6, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3], "isController": false}, {"data": ["Home Page- HTTP Request", 400, 143, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 99, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 22, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 19, "Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 2, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1], "isController": false}, {"data": ["Selenium Manager - HTTP Request", 400, 137, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 99, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 34, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Software caused connection abort: connect", 1, "", ""], "isController": false}, {"data": ["Formulas - HTTP Request", 400, 256, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 207, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 39, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 5, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, "Non HTTP response code: org.apache.http.conn.HttpHostConnectException/Non HTTP response message: Connect to www.easycalculation.com:443 [www.easycalculation.com/173.255.199.118, www.easycalculation.com/64:ff9b:0:0:0:0:adff:c776] failed: Connection timed out: connect", 1], "isController": false}, {"data": ["Blood Tests - HTTP Request", 400, 220, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 139, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 71, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 7, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 3, "", ""], "isController": false}, {"data": ["Offers - HTTP Request", 400, 206, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 132, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 68, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 4, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "Non HTTP response code: javax.net.ssl.SSLProtocolException/Non HTTP response message: (unexpected_message) Received close_notify during handshake", 1], "isController": false}, {"data": ["Product 1 - HTTP Request", 400, 127, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 98, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 14, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 12, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 1], "isController": false}, {"data": ["FAQ - HTTP Request", 400, 266, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 218, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 40, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 6, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 2, "", ""], "isController": false}, {"data": ["Product 2 - HTTP Request", 400, 125, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 99, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 15, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 5, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: demoblaze.com:443 failed to respond", 5, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 1], "isController": false}, {"data": ["Chromium - HTTP Request", 400, 209, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 132, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 68, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 8, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 1, "", ""], "isController": false}, {"data": ["Unit Conversion - HTTP Request", 400, 255, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.easycalculation.com", 207, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Network is unreachable: connect", 39, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 5, "Non HTTP response code: java.net.SocketException/Non HTTP response message: An established connection was aborted by the software in your host machine", 4, "", ""], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
