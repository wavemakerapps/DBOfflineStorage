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

Page.liveform1_many2oneCsBeforeadd = function ($event, widget, newItem) {
    debugger;
    if (newItem.iscustom) {
        newItem.datavalue.textCol = newItem.displayvalue;
        newItem.datavalue.timeCol = "01:01:01";
        newItem.datavalue.datetimeCol = moment(new Date()).utcOffset("+05:30").format('YYYY-MM-DDTHH:mm:ss');
        newItem.datavalue.timestampCol = moment(new Date()).utcOffset("+05:30").format('YYYY-MM-DDTHH:mm:ss');
        console.log(Page.Variables.Many2oneCData.dataSet);
    }
};

