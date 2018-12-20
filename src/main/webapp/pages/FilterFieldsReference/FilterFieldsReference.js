/* perform any action on widgets/variables within this block */

Page.onReady = function () {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */

};

Page.button3Tap = function ($event, widget) {
    debugger;
    Page.Variables.OfflineDatabaseDefinedEmployeeData.listRecords({
        filterFields: {
            "uniqueColumn": {
                "value": "EU1"
            }
        }
    }, function (data) {
        console.log('success', data);
    }, function (error) {
        console.error('error', error);
    });

};

