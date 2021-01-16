export class CommonConstants {
    
}

export const STD = {
    NINE : 9,
    TEN : 10,
    ELEVEN : 11,
    TWELVE : 12
  } as const;
  export const STD_LIST = [STD.NINE , STD.TEN , STD.ELEVEN, STD.TWELVE]

  export const STREAM = {
    SCIENCE : "Science",
    COMMARCE : "Commarce",
    ARTS : "Arts"
  } as const;
  export const STREAM_LIST = [STREAM.SCIENCE , STREAM.COMMARCE , STREAM.ARTS]

  export const DIVISION = {
    A : "A",
    B : "B",
    C : "C",
    D : "D",
    E : "E",
    F : "F"
  } as const;
  export const DIVISION_LIST = [DIVISION.A , DIVISION.B , DIVISION.C, DIVISION.D, DIVISION.E, DIVISION.F]
