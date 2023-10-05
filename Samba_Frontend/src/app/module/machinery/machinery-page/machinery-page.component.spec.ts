import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MachineryPageComponent } from './machinery-page.component';

describe('MachineryPageComponent', () => {
  let component: MachineryPageComponent;
  let fixture: ComponentFixture<MachineryPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MachineryPageComponent]
    });
    fixture = TestBed.createComponent(MachineryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
