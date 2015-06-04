/**
 * Created by thuynghi on 5/6/2015.
 */
function reportController($scope, $http) {
    // java script function for show to web
    $scope.viewInformation = function () {
        $http.get('viewInformation').success(function (response) {
            $scope.information = response;

            pieChartGender($scope.information.male, $scope.information.female);

            var dataExperience = [$scope.information.yearExperiences_0, $scope.information.yearExperiences_1, $scope.information.yearExperiences_2, $scope.information.yearExperiences_3, $scope.information.yearExperiences_4, $scope.information.yearExperiences_5];
            pieChartExperience(dataExperience);

            var dataReadiness = [$scope.information.readiness_0, $scope.information.readiness_1, $scope.information.readiness_2, $scope.information.readiness_3, $scope.information.readiness_4, $scope.information.readiness_5];
            pieChartReadiness(dataReadiness);
        })
    }

    // call viewInformation() function to store in scope variable of angularJS to show out
    $scope.viewInformation();

    // store options variables in scope variables of angularJS to change to file report.jsp
    $scope.options = {
        years: ["2014", "2015", "2016", "2017", "2018", "2019", "2020"],
        months: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"]
    };

    $scope.viewInformationByMonth = function () {
        // Remember write controller for it
        $http.get('getInformationByMonth', {params: {month1: $scope.date.choiceMonth1, year1: $scope.date.choiceYear1, month2: $scope.date.choiceMonth2, year2: $scope.date.choiceYear2}})
            .success(function (dataJSON) {

                var chart = AmCharts.makeChart("chartdiv", {
                    "type": "serial",
                    "path":"",
                    "theme": "light",
                    "legend": {
                        "equalWidths": false,
                        "useGraphSettings": true,
                        "valueAlign": "left",
                        "valueWidth": 120
                    },

                    "dataProvider": dataJSON,

                    "valueAxes": [{ // Pool Size Column
                        "id": "poolSizeAxis",
                        "axisAlpha": 0.4,
                        "gridAlpha": 0.1,
                        "position": "left",
                        "title": "Pool Size"
                    },
                        // In axis
                        // Out axis
                    ],

                    // Graph fields:
                    // Column graphs
                    "graphs": [{
                        "alphaField": "alpha",
                        "balloonText": "[[value]] members",
                        "dashLengthField": "dashLength",
                        "fillAlphas": 0.7,

                        "legendPeriodValueText": "total: [[value.sum]] members",
                        "legendValueText": "[[value]] members",
                        "title": "Pool Size",

                        "type": "column",
                        "valueField": "poolSize",
                        "valueAxis": "poolSizeAxis"
                    },

                        // Lines graph
                        {// Out Line
                            "balloonText": "Out:[[value]]",
                            "bullet": "round",
                            "bulletBorderAlpha": 1,
                            "useLineColorForBulletBorder": true,
                            "bulletColor": "#FFFFFF",
                            "bulletSizeField": "townSize",
                            "dashLengthField": "dashLength",
                            "descriptionField": "townName",
                            "labelPosition": "right",
                            "labelText": "[[townName2]]",

                            "legendValueText": "[[value]]",
                            "title": "Out",
                            "fillAlphas": 0,

                            "valueField": "outMembersByMonth",
                            "valueAxis": "outMembersByMonthAxis"
                        }, {// Out Line
                            "balloonText": "In:[[value]]",
                            "bullet": "square",
                            "bulletBorderAlpha": 1,
                            "bulletBorderThickness": 1,
                            "dashLengthField": "dashLength",

                            "legendValueText": "[[value]]",

                            "title": "In",
                            "fillAlphas": 0,

                            "valueField": "inMembersByMonth",
                            "valueAxis": "inMembersByMonthAxis"
                        }],


                    // Cursor bubble
                    "chartCursor": {
                        "categoryBalloonDateFormat": "DD",
                        "cursorAlpha": 0.1,
                        "cursorColor":"#FF0320",
                        "fullWidth":true,
                        "valueBalloonsEnabled": false,
                        "zoomable": false
                    },
                    "dataDateFormat": "YYYY-MM",
                    "categoryField": "yearMonth",
                    "categoryAxis": {
                        "dateFormats": [{
                            "period": "DD",
                            "format": "DD"
                        }],
                        "parseDates": false,
                        "autoGridCount": true,
                        "axisColor": "#000000",
                        "gridAlpha": 0.1,
                        "gridColor": "#000000",
                        "gridCount": 50
                    },
                    "export": {
                        "enabled": true
                    }
                });

            }).error(function (dataJSON) {
            console.log(dataJSON);
        })
    }

    // pie chart -------------------------------------------------------------------
    // pie chart gender
    function pieChartGender(male, female) {
        // pie chart data
        var pieData = [
            {
                value: male,
                label: "Male",
                color: "#878BB6"
            },
            {
                value: female,
                label: "Female",
                color: "#4ACAB4"
            }
        ];
        // pie chart options
        var pieOptions = {
            segmentShowStroke: false,
            animateScale: true
        }
        // get pie chart canvas
        var gender = document.getElementById("gender").getContext("2d");
        // draw pie chart
        new Chart(gender).Pie(pieData, pieOptions);
    }

    // pie chart experience
    function pieChartExperience(data) {
        // pie chart data
        var pieData = [
            {
                value: data[0],
                label: "<0.5",
                color: "#878BB6"
            },
            {
                value: data[1],
                label: "0.5-1 year",
                color: "#4ACAB4"
            },
            {
                value: data[2],
                label: "1-2 years",
                color: "#FF8153"
            },
            {
                value: data[3],
                label: "2-3 years",
                color: "#FFEA88"
            },
            {
                value: data[4],
                label: "3-5 years",
                color: "#00008B"
            },
            {
                value: data[5],
                label: "5+ years",
                color: "#8B008B"
            }
        ];
        // pie chart options
        var pieOptions = {
            segmentShowStroke: false,
            animateScale: true
        }
        // get pie chart canvas
        var experience = document.getElementById("experience").getContext("2d");
        // draw pie chart
        new Chart(experience).Pie(pieData, pieOptions);
    }

    // pie chart readiness
    function pieChartReadiness(data) {
        // pie chart data
        var pieData = [
            {
                value: data[0],
                label: "1 Week",
                color: "#878BB6"
            },
            {
                value: data[1],
                label: "1 - 2 weeks",
                color: "#4ACAB4"
            },
            {
                value: data[2],
                label: "2 weeks - 1 months",
                color: "#FF8153"
            },
            {
                value: data[3],
                label: "1 - 3 months",
                color: "#FFEA88"
            },
            {
                value: data[4],
                label: "3 - 6 months",
                color: "#00008B"
            },
            {
                value: data[5],
                label: "Unknown",
                color: "#8B008B"
            }
        ];
        // pie chart options
        var pieOptions = {
            segmentShowStroke: false,
            animateScale: true
        }
        // get pie chart canvas
        var readiness = document.getElementById("readiness").getContext("2d");
        // draw pie chart
        new Chart(readiness).Pie(pieData, pieOptions);
    }

    // column line monthly report chart
    function columnLineChartMonths(data){
        var columnLineMonths = [
            {
                date: data[0],
                poolSize: data[0],
                outMembers: data[1],
                inMembers: data[2]
            }
        ];
    }

    var setDataProvider = function(dataJSON){
        return dataJSON;

    }


}