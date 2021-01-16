import { StringUtil } from './StringUtil';

export class MenuConstatns {
    public static menuList = {
        CLASS_MENU: "classes",
        STUDENT_MENU: "students"
    }

    public static getMenuPath(menuKey: string): string {
        if (StringUtil.isNonEmptyString(menuKey)) {
            return this.menuList[menuKey]
        }
        return '';
    }
}
