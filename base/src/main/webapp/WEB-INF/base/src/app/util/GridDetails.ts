export class GridDetail {
    private _gridData:any[];
    private _displayColumnDetails:any[];

    public get gridData() {
        return this._gridData;
    }
    public set gridData(data) {
        this._gridData = data;
    }

    public get displayColumnDetails() {
        return this._displayColumnDetails;
    }
    public set displayColumnDetails(data) {
        this._displayColumnDetails = data;
    }

}