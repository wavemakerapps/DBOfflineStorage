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

Page.OfflineClassicDBOrdersDataonBeforeListRecords = function (variable, dataFilter, options) {
    debugger;
    // options.filterFields = {
    //     "customerNumber": {
    //         value: 128
    //     }
    // };

    return {
        "condition": "AND",
        "rules": [{
            "matchMode": "anywhereignorecase",
            "required": false,
            "secondvalue": "",
            "target": "status",
            "type": "string",
            "value": "Shipped"
        }, {
            "target": "customerNumber",
            "type": "integer",
            "matchMode": "exact",
            "value": 128,
            "required": true
        }]
    };

};

